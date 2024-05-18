package com.maan.eway.springbatch;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maan.eway.batch.entity.EserviceMotorDetailsRaw;
import com.maan.eway.batch.entity.EwayEmplyeeDetailRaw;
import com.maan.eway.batch.entity.EwayUploadTypeMaster;
import com.maan.eway.batch.entity.EwayXlconfigMaster;
import com.maan.eway.batch.entity.TransactionControlDetails;
import com.maan.eway.batch.repository.EserviceMotorDetailsRawRepository;
import com.maan.eway.batch.repository.EwayEmplyeeDetailRawRepository;
import com.maan.eway.batch.repository.EwayUploadTypeMasterRepository;
import com.maan.eway.batch.repository.TransactionControlDetailsRepository;
import com.maan.eway.batch.req.DeleteRecordReq;
import com.maan.eway.batch.req.EditRecordReq;
import com.maan.eway.batch.req.GetRecordsReq;
import com.maan.eway.batch.req.GetUploadTransactionReq;
import com.maan.eway.batch.req.SamplFileDownloadReq;
import com.maan.eway.batch.res.GetEmployeeDetailsRes;
import com.maan.eway.batch.res.GetRecordsRes;
import com.maan.eway.batch.res.GetTransactionStatusRes;
import com.maan.eway.batch.res.GetUploadTransactionRes;
import com.maan.eway.batch.res.UpdateRecordReq;
import com.maan.eway.common.service.impl.EserviceMotorDetailsServiceImpl;
import com.maan.eway.common.service.impl.GenerateSeqNoServiceImpl;
import com.maan.eway.error.Error;
import com.maan.eway.res.CommonRes;


@Service
public class SpringBatchServiceImpl implements SpringBatchService {
	
	
	@Value("${eway.xl.batch.upload}")
	private String filePath ;
	
	@Value("${tira.api}")
	private String tiraApi;
	
	Logger log =LogManager.getLogger(SpringBatchServiceImpl.class);

	@Autowired
	private CSVFileConvertion csvFileConvertion;
	@Autowired
	private EwayUploadTypeMasterRepository uploadTypeRepo;
	@Autowired
	private TransactionControlDetailsRepository transRepo;
	@Autowired
	private EserviceMotorDetailsRawRepository eserviceRepository;
	@Autowired
	private GenerateSeqNoServiceImpl sequence;
	@Autowired
	private AsynchronousProcess asyncProcess;
	@Autowired
	private EserviceMotorDetailsServiceImpl requestRefNo;
	@Autowired
    JobLauncher jobLauncher;
    @Autowired
    Job processJob;
    
    @Autowired
    private EwayEmplyeeDetailRawRepository employeeRawRepo;
    @Autowired
    private InputRecordValidation validation;
    
    //private static ObjectMapper mapper =new ObjectMapper();
    
    private static SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
    
	@Override
	public EwayUploadRes batchUpload(MultipartFile file,EwayUploadReq req,String token) {
		EwayUploadRes uploadRes =new EwayUploadRes();
		try {
			String fileName =FilenameUtils.getBaseName(file.getOriginalFilename());
			String extension =FilenameUtils.getExtension(file.getOriginalFilename());
			
			uploadRes.setTypeId(req.getTypeId());
			uploadRes.setProductId(req.getProductId());
			uploadRes.setCompanyId(req.getCompanyId());
			uploadRes.setExcelFileName(file.getOriginalFilename());
			uploadRes.setProgressStatus("P");
			uploadRes.setProgressdesc("Uploading...");
			uploadRes.setRequestReferenceNo(StringUtils.isBlank(req.getRequestReferenceNo())?getRequestRefNo(req.getCompanyId(), req.getBranchCode(), req.getProductId()):req.getRequestReferenceNo());
			uploadRes.setToken(token);
			uploadRes.setBrokerBranchCode(StringUtils.isBlank(req.getBrokerBranchCode())?"":req.getBrokerBranchCode());
			uploadRes.setAcExecutiveId(StringUtils.isBlank(req.getAcExecutiveId())?"":req.getAcExecutiveId());
			uploadRes.setApplicationId(StringUtils.isBlank(req.getApplicationId())?"":req.getApplicationId());
			uploadRes.setBeokerCode(StringUtils.isBlank(req.getBeokerCode())?"":req.getBeokerCode());
			uploadRes.setBranchCode("");
			uploadRes.setCurrency(StringUtils.isBlank(req.getCurrency())?"":req.getCurrency());
			if("Y".equalsIgnoreCase(req.getEndorsementYn())) {
				uploadRes.setEndorsementDate(StringUtils.isBlank(req.getEndorsementDate())?"":req.getEndorsementDate());
				uploadRes.setEndorsementEffectiveDate(StringUtils.isBlank(req.getEndorsementEffectiveDate())?"":req.getEndorsementEffectiveDate());
				uploadRes.setEndorsementRemarks(StringUtils.isBlank(req.getEndorsementRemarks())?"":req.getEndorsementRemarks());
				uploadRes.setEndorsementType(StringUtils.isBlank(req.getEndorsementType())?"":req.getEndorsementType());
				uploadRes.setEndorsementTypeDesc(StringUtils.isBlank(req.getEndorsementTypeDesc())?"":req.getEndorsementTypeDesc());
				uploadRes.setEndorsementYn(StringUtils.isBlank(req.getEndorsementYn())?"":req.getEndorsementYn());
				uploadRes.setEndtCategoryDesc(StringUtils.isBlank(req.getEndtCategoryDesc())?"":req.getEndtCategoryDesc());
				uploadRes.setEndtCount(StringUtils.isBlank(req.getEndtCount())?"":req.getEndtCount());
				uploadRes.setEndtPrevPolicyNo(StringUtils.isBlank(req.getEndtPrevPolicyNo())?"":req.getEndtPrevPolicyNo());
				uploadRes.setEndtStatus(StringUtils.isBlank(req.getEndtStatus())?"":req.getEndtStatus());
			}
			uploadRes.setExchangeRate(StringUtils.isBlank(req.getExchangeRate())?"":req.getExchangeRate());
			uploadRes.setHavePromoCode(StringUtils.isBlank(req.getHavePromoCode())?"":req.getHavePromoCode());
			uploadRes.setIsFinanceEndt(StringUtils.isBlank(req.getIsFinanceEndt())?"":req.getIsFinanceEndt());
			uploadRes.setLoginId(StringUtils.isBlank(req.getLoginId())?"":req.getLoginId());
			uploadRes.setNoOfVehicles(StringUtils.isBlank(req.getNoOfVehicles())?"":req.getNoOfVehicles());
			uploadRes.setOrginalPolicyNo(StringUtils.isBlank(req.getOrginalPolicyNo())?"":req.getOrginalPolicyNo());
			uploadRes.setPolicyEndDate(StringUtils.isBlank(req.getPolicyEndDate())?"":req.getPolicyEndDate());
			uploadRes.setPolicyStartDate(StringUtils.isBlank(req.getPolicyStartDate())?"":req.getPolicyStartDate());
			uploadRes.setSubUserType(StringUtils.isBlank(req.getSubUserType())?"":req.getSubUserType());
			uploadRes.setCustomerRefNo(StringUtils.isBlank(req.getCustomerRefNo())?"":req.getCustomerRefNo());
			uploadRes.setBranchCode(StringUtils.isBlank(req.getBranchCode())?"":req.getBranchCode());
			uploadRes.setAgencyCode(StringUtils.isBlank(req.getAgencyCode())?"":req.getAgencyCode());
			uploadRes.setIdnumber(StringUtils.isBlank(req.getIdnumber())?"":req.getIdnumber());
			uploadRes.setUserType(StringUtils.isBlank(req.getUserType())?"":req.getUserType());
			uploadRes.setNcdYn(StringUtils.isBlank(req.getNcdYn())?"N":req.getNcdYn());
			uploadRes.setRiskId(StringUtils.isBlank(req.getRiskId())?"":req.getRiskId());
			uploadRes.setQuoteNo(StringUtils.isBlank(req.getQuoteNo())?"":req.getQuoteNo());
			uploadRes.setSourceType(StringUtils.isBlank(req.getSourceType())?"":req.getSourceType());
			uploadRes.setCustomerCode(StringUtils.isBlank(req.getCustomerCode())?"":req.getCustomerCode());
			
			LocalDateTime dateTime =LocalDateTime.now();
			System.out.println(dateTime);
			String excelFilePath=filePath+fileName+dateTime.getNano()+"."+extension;
			Path path =Paths.get(excelFilePath);
			file.transferTo(path);
			
			uploadRes.setExcelFilePath(excelFilePath);
			
			EwayUploadTypeMaster uploadTypeMaster=uploadTypeRepo.findByCompanyIdAndProductIdAndTypeidAndStatus(Integer.valueOf(req.getCompanyId()),Integer.valueOf(req.getProductId()),
					Integer.valueOf(req.getTypeId()),"Y");
			
			saveUploadTransactionData(uploadRes);
			
			Thread_CSV_Convertion thread = new Thread_CSV_Convertion(uploadRes,csvFileConvertion,uploadTypeMaster);
			Thread job =new Thread(thread);
			job.setName("EWAY_BATCH_UPLOAD");
			job.setDaemon(false);
			job.start();
			
			
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		
		return uploadRes;
	}

	public void doRawdataInsert(EwayUploadRes uploadResponse, EwayUploadTypeMaster uploadTypeMaster,
			List<EwayXlconfigMaster> xlConfigData) {
		try {
			String typeId = "",uploadedTranId="",rawTable="",mainTable="",errorTable="",fileUploadTypeId="";
			String mandatoryDetails="",dataTypeList="",dateFormatList="",duplicateColumnList="",duplicateExcelColumnList="",newVehMandatoryDetails="";
			EwayUploadTypeMaster uploadData = uploadTypeMaster;
        	typeId=uploadData.getTypeid()==null?"":uploadData.getTypeid().toString();
			uploadedTranId=uploadResponse.getRequestReferenceNo();
			rawTable=uploadData.getRawTableName()==null?"":uploadData.getRawTableName();
			fileUploadTypeId=uploadData.getTypeid()==null?"":uploadData.getTypeid().toString();
			log.info("insertRecords - Enter || typeId: " + typeId);
			log.info("TransactionId : "+uploadedTranId+" Fetching Records from CSV....");
        	fileUploadProgress(uploadResponse,"P","","Fetching Records from CSV","50");
			String excelHeaderName="",headerList="";
			for(int i=0;i<xlConfigData.size();i++) {
				EwayXlconfigMaster updatedData = xlConfigData.get(i);
				excelHeaderName = updatedData.getExcelheaderName()==null?"":updatedData.getExcelheaderName();
		    	if(StringUtils.isNotBlank(excelHeaderName)) {
		    		headerList = headerList+"\""+excelHeaderName+ "\""+",";
		    	}
		    }
			String rawtablecolumnslist="",rawtablecolumns="";
			List<XlConfigData> datas =new ArrayList<XlConfigData>();
			for(int i=0;i<xlConfigData.size();i++) {
				EwayXlconfigMaster updatedData = xlConfigData.get(i);
		    	rawtablecolumns = updatedData.getFieldNameRaw()==null?"":updatedData.getFieldNameRaw();
		    	String excelHeaderDuplicateColumn=updatedData.getExcelheaderName()==null?"":updatedData.getExcelheaderName();
		    	if(StringUtils.isNotBlank(excelHeaderName)) {
		    		rawtablecolumnslist = rawtablecolumnslist+"\""+rawtablecolumns+ "\""+",";
		    		String mandatoryYN = updatedData.getMandatoryyn()==null?"N":updatedData.getMandatoryyn();
		    		//String newVehMandatoryYN = updatedData.getv()==null?"N":updatedData.getNewvehiclemandatoryyn();
		    		String dataType= updatedData.getDataType()==null?"":updatedData.getDataType();
		    		String dateformat= updatedData.getDateFormat()==null?"":updatedData.getDateFormat();
		    		mandatoryDetails +=mandatoryYN+"~";
		    		//newVehMandatoryDetails +=newVehMandatoryYN+"~";
		    		if(dataType==null || dataType.isEmpty()) {
		    			dataTypeList +=dataType+"~"+null;
		    		}else {
		    			dataTypeList +=dataType+"~";

		    		}
		    		dateFormatList +=dateformat+"~";
		    		String duplicateColumn= updatedData.getDublicateCheck()==null?"":updatedData.getDublicateCheck();
				    	if(StringUtils.isNotBlank(duplicateColumn)&&duplicateColumn.equalsIgnoreCase("Y")) {
		    			duplicateColumnList +=rawtablecolumns+",";
		    			duplicateExcelColumnList +=excelHeaderDuplicateColumn+",";
		    		}
		    	}
		    	
		    	XlConfigData configData =XlConfigData.builder()
		    			.datatype(updatedData.getDataType())
		    			.rawTableColumns(updatedData.getFieldNameRaw())
		    			.build();
		    	datas.add(configData);
		    }
				 
			EwayBatchReq request = new EwayBatchReq();
			uploadResponse.setTypeId(fileUploadTypeId);
			uploadResponse.setExcelrawtablename(rawTable);
			uploadResponse.setExcelrawtablefields(StringUtils.chop((rawtablecolumnslist).replace("\"", "")));
			uploadResponse.setExcelmandatorylist(mandatoryDetails);
			uploadResponse.setTableColumnsDataType(dataTypeList); 
			uploadResponse.setExceldateformatlist(dateFormatList); 
			uploadResponse.setExcelHeaderColumns(headerList);
			uploadResponse.setDuplicatecheckcolumns(StringUtils.chop(duplicateColumnList));
			uploadResponse.setDuplicatecheckexcelcolumns(StringUtils.chop(duplicateExcelColumnList));
			request.setEwayUploadRes(uploadResponse); 
			uploadResponse.setXlConfigData(datas);
			ObjectMapper mapper = new ObjectMapper();
			String ewayBatchReq=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
			
			// delete old record
			if("14".equals(uploadResponse.getProductId()) || "15".equals(uploadResponse.getProductId()) || "32".equals(uploadResponse.getProductId())) {
				transRepo.updateOldRecords("Deleted by "+uploadResponse.getLoginId(),uploadResponse.getCompanyId(),uploadResponse.getProductId(),uploadResponse.getRiskId(),uploadResponse.getRequestReferenceNo(),
						uploadResponse.getQuoteNo());
			}else if("5".equalsIgnoreCase(uploadResponse.getProductId())) {
				transRepo.updateOldMotorRecords("Deleted by "+uploadResponse.getLoginId(),uploadResponse.getRequestReferenceNo(),uploadResponse.getCompanyId(),
						uploadResponse.getProductId());
			}
			
			JobParameters jobParameters = new JobParametersBuilder()
			     	.addLong("time", System.currentTimeMillis())
			     	.addString("EwayBatchReq", ewayBatchReq)
			     	.addString("RequestReferenceNo", uploadResponse.getRequestReferenceNo())
			     	.addString("ExcelHeaderNames", StringUtils.chop(headerList))
			        .toJobParameters();
					jobLauncher.run(processJob, jobParameters);
					
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		
	}
		
	public void fileUploadProgress(EwayUploadRes uploadResponse,String progressStatus,String errordesc,String progrssDesc,String loading){
		try {
				uploadResponse.setProgressdesc(progrssDesc); 
				uploadResponse.setProgressErrordesc(errordesc); 
				uploadResponse.setProgressStatus(progressStatus);
				saveUploadTransactionData(uploadResponse);
			}catch (Exception e) {log.error(e);}
	}
	
	public void saveUploadTransactionData(EwayUploadRes res ) {
		try {
			TransactionControlDetails controlDetails = TransactionControlDetails.builder()
					.branchCode(StringUtils.isBlank(res.getBranchCode())?"":res.getBranchCode())
					.companyId(StringUtils.isBlank(res.getCompanyId())?null:Integer.valueOf(res.getCompanyId()))
					.entryDate(new Date())
					.errorDescription(StringUtils.isBlank(res.getProgressErrordesc())?"":res.getProgressErrordesc())
					.errorRecords(StringUtils.isBlank(res.getErrorRecords())?0:Integer.valueOf(res.getErrorRecords()))
					.validRecords(StringUtils.isBlank(res.getValidRecords())?0:Integer.valueOf(res.getValidRecords()))
					.totalRecords(StringUtils.isBlank(res.getToatalRows())?0:Integer.valueOf(res.getToatalRows()))
					.fileName(StringUtils.isBlank(res.getExcelFileName())?"":res.getExcelFileName())
					.filePath(StringUtils.isBlank(res.getExcelFilePath())?"":res.getExcelFilePath())
					.lastUpdatedDate(new Date())
					.loadPercentage(null)
					.loginName(StringUtils.isBlank(res.getUploadedBy())?"":res.getUploadedBy())
					.productId(StringUtils.isBlank(res.getProductId())?null:Integer.valueOf(res.getProductId()))
					.progressDescription(StringUtils.isBlank(res.getProgressdesc())?"":res.getProgressdesc())
					.requestReferenceNo(res.getRequestReferenceNo())
					.sectionId(StringUtils.isBlank(res.getSectionId())?null:Integer.valueOf(res.getSectionId()))
					.status(StringUtils.isBlank(res.getProgressStatus())?"":res.getProgressStatus())
					.typeId(Long.valueOf(res.getTypeId()))
					.tranDate(new Date())
					.build();
			transRepo.saveAndFlush(controlDetails);
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
	}

	public void validateRawTableRecords(EwayUploadRes uploadResponse) {
		Long totalRecords =0L;
		Long validRecords =0L;
		Long errorRecords =0L;
		Long deletedRecords = 0L ;
		try {
			String type_id =uploadResponse.getTypeId();
			fileUploadProgress(uploadResponse,"P","Uploading","Validating raw table records","50");
			if("5".equals(uploadResponse.getProductId()) && "101".equals(type_id)) {
				Integer companyId =Integer.valueOf(uploadResponse.getCompanyId());
				Integer productId =Integer.valueOf(uploadResponse.getProductId());
				Integer typeId =Integer.valueOf(uploadResponse.getTypeId());
				String requestReferenceNo =uploadResponse.getRequestReferenceNo();
				eserviceRepository.updateInsuranceTypeId(companyId, productId, typeId, requestReferenceNo);
				eserviceRepository.updateSectionIdByRequestRefNo(companyId, productId, typeId, requestReferenceNo);
				eserviceRepository.updateBodyTypeId(companyId, productId, typeId, requestReferenceNo);
				eserviceRepository.updateInsuranceClassId(companyId, productId, typeId, requestReferenceNo);
				eserviceRepository.updateMotorUsageId(companyId, productId, typeId, requestReferenceNo);
				eserviceRepository.updateSuminsuredValidationByPolicyType(companyId, productId, typeId, requestReferenceNo);
				eserviceRepository.updateCollateralValidation(companyId, productId, typeId, requestReferenceNo);
				eserviceRepository.updateMasterIdEmptyValidation(companyId, productId, typeId, requestReferenceNo);
				eserviceRepository.updateDupicateSearchBydata(companyId, productId, typeId, requestReferenceNo);
				
				List<EserviceMotorDetailsRaw> list =eserviceRepository.findByCompanyIdAndProductIdAndRequestReferenceNoAndStatusIgnoreCase(Integer.valueOf(uploadResponse.getCompanyId()),
						Integer.valueOf(uploadResponse.getProductId()),uploadResponse.getRequestReferenceNo(),"Y");
				log.info("validateRawTableRecords || Partitions size "+list.size());
				
				List<List<EserviceMotorDetailsRaw>> partitionsList =nPartition(list,list.size()>10?list.size()/6:10);
				
				for(List<EserviceMotorDetailsRaw> eList :partitionsList) {
					
					//parallel call
					List<CompletableFuture<String>> comFutures = eList.stream()
							.map(e -> asyncProcess.validateTira(e, uploadResponse))
							.collect(Collectors.toList());
							
					@SuppressWarnings("unchecked")
					CompletableFuture<Object> [] array =new CompletableFuture[comFutures.size()];
					comFutures.toArray(array);
					CompletableFuture.allOf(array).join();
				}
					
			
				List<EserviceMotorDetailsRaw> dlist =eserviceRepository.findByRequestReferenceNo(uploadResponse.getRequestReferenceNo());
				validRecords =dlist.stream().filter(p ->"Y".equals(p.getStatus())).count();
				errorRecords =dlist.stream().filter(p ->"E".equals(p.getStatus())).count();
				deletedRecords =dlist.stream().filter(p ->"D".equals(p.getStatus())).count();
				totalRecords =validRecords + errorRecords;
			}else if("102".equals(type_id) || "103".equals(type_id) || "104".equals(type_id)) {
				
				employeeRawRepo.updateOccupationId(Integer.valueOf(uploadResponse.getCompanyId()),Integer.valueOf(uploadResponse.getProductId()),
						Integer.valueOf(uploadResponse.getRiskId()),uploadResponse.getRequestReferenceNo(),uploadResponse.getQuoteNo());
				
				employeeRawRepo.updateDuplicateNationalityId(uploadResponse.getRequestReferenceNo(),uploadResponse.getQuoteNo(),Integer.valueOf(uploadResponse.getCompanyId()),Integer.valueOf(uploadResponse.getProductId()),
						Integer.valueOf(uploadResponse.getRiskId()));
				
				employeeRawRepo.checkSuminsuredValidation(uploadResponse.getQuoteNo(), uploadResponse.getRequestReferenceNo(), uploadResponse.getCompanyId(),
						uploadResponse.getRiskId(), uploadResponse.getProductId());
				
				employeeRawRepo.checkDateOfjoiningAndDateOfBirth(uploadResponse.getQuoteNo(), uploadResponse.getRequestReferenceNo(), uploadResponse.getCompanyId(),
						uploadResponse.getRiskId(), uploadResponse.getProductId());
				
				List<EwayEmplyeeDetailRaw> emp_list =employeeRawRepo.findByCompanyIdAndProductIdAndQuoteNoAndRiskIdAndRequestReferenceNo(
						Integer.valueOf(uploadResponse.getCompanyId()),Integer.valueOf(uploadResponse.getProductId()),uploadResponse.getQuoteNo(),
						Integer.valueOf(uploadResponse.getRiskId()),uploadResponse.getRequestReferenceNo());
				
				if(!CollectionUtils.isEmpty(emp_list)) {
					
					errorRecords =emp_list.stream().filter(f -> "E".equalsIgnoreCase(f.getStatus()))
							.count();
					validRecords =emp_list.stream().filter(f -> "Y".equalsIgnoreCase(f.getStatus()))
							.count();
					deletedRecords =emp_list.stream().filter(f -> "D".equalsIgnoreCase(f.getStatus()))
							.count();
					totalRecords =errorRecords + validRecords;
					
					
				}
			}
			uploadResponse.setToatalRows(String.valueOf(totalRecords));
			uploadResponse.setErrorRecords(String.valueOf(errorRecords));
			uploadResponse.setValidRecords(String.valueOf(validRecords));
			uploadResponse.setDeletedRecords(String.valueOf(deletedRecords));
			fileUploadProgress(uploadResponse,"S","BatchUploaded","Batch inserted successfully","50");

		}catch (Exception e) {
			fileUploadProgress(uploadResponse,"E","Failed","Raw table Insert Batch Failed","50");
			log.error(e);
			e.printStackTrace();
		}
		
	}

	
	private <T> List<List<T>> nPartition(List<T> objs, final int N) {
	    return new ArrayList<>(IntStream.range(0, objs.size()).boxed().collect(
	            Collectors.groupingBy(e->e/N,Collectors.mapping(e->objs.get(e), Collectors.toList())
	                    )).values());
	    }

	@Override
	public CommonRes getUploadTransaction(GetUploadTransactionReq req) {
		CommonRes res = new CommonRes();
		try {
			TransactionControlDetails d =transRepo.findByCompanyIdAndProductIdAndRequestReferenceNo(
					Integer.valueOf(req.getCompanyId()),Integer.valueOf(req.getProductId()),req.getRequestRefNo());
			if(d!=null) {
				GetUploadTransactionRes transactionRes =GetUploadTransactionRes.builder()
					.companyId(d.getCompanyId()==null?"":d.getCompanyId().toString())
					.productId(d.getProductId()==null?"":d.getProductId().toString())
					.requestRefNo(StringUtils.isBlank(d.getRequestReferenceNo())?"":d.getRequestReferenceNo())
					.uploadDate(d.getEntryDate()==null?"":sdf.format(d.getEntryDate()))
					.totalRecords(d.getTotalRecords()==null?"0":d.getTotalRecords().toString())	
					.validRecords(d.getValidRecords()==null?"0":d.getValidRecords().toString())
					.errorRecords(d.getErrorRecords()==null?"0":d.getErrorRecords().toString())
					//.deletedRecords(d.getDeletedRecords()==null?"0":d.getDeletedRecords().toString())
					.build();
				
				res.setCommonResponse(transactionRes);
				res.setMessage("SUCCESS");
			}else {
				res.setCommonResponse(null);
				res.setMessage("FAILED");
			}
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public CommonRes getTransactionStatus(GetUploadTransactionReq req) {
		CommonRes res = new CommonRes();
		try {
			TransactionControlDetails data =transRepo.findByCompanyIdAndProductIdAndRequestReferenceNo(
					Integer.valueOf(req.getCompanyId()),Integer.valueOf(req.getProductId()),req.getRequestRefNo());
			if(data!=null) {
				GetTransactionStatusRes transactionStatusRes =GetTransactionStatusRes.builder()
						.status(data.getStatus())
						.statusDesc(data.getProgressDescription())
						.build();
				res.setCommonResponse(transactionStatusRes);
				res.setMessage("SUCCESS");
			}else {
				res.setCommonResponse(null);
				res.setMessage("FAILED");
			}
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public CommonRes getRecordByStatus(GetRecordsReq req) {
		CommonRes res = new CommonRes();
		ArrayList<GetRecordsRes> arrayList =new ArrayList<GetRecordsRes>();
		try {			
			//motor grid
			if("5".equals(req.getProductId())) {
				List<EserviceMotorDetailsRaw> list =new ArrayList<EserviceMotorDetailsRaw>();
				
				if("E".equalsIgnoreCase(req.getStatus())) {
					list =eserviceRepository.findByCompanyIdAndProductIdAndRequestReferenceNoAndStatusIgnoreCase(
							Integer.valueOf(req.getCompanyId()),Integer.valueOf(req.getProductId()),req.getRequestRefNo(),req.getStatus());
				}else if("D".equalsIgnoreCase(req.getStatus())) {
					list =eserviceRepository.findByCompanyIdAndProductIdAndRequestReferenceNoAndStatusIgnoreCase(
							Integer.valueOf(req.getCompanyId()),Integer.valueOf(req.getProductId()),req.getRequestRefNo(),req.getStatus());
				
				}else if("Y".equalsIgnoreCase(req.getStatus())) {
					list =eserviceRepository.findByCompanyIdAndProductIdAndRequestReferenceNoAndStatusIgnoreCase(
							Integer.valueOf(req.getCompanyId()),Integer.valueOf(req.getProductId()),req.getRequestRefNo(),req.getStatus());
				}
				
				if(!CollectionUtils.isEmpty(list)) {
					list.forEach(p ->{
						GetRecordsRes recordsRes =GetRecordsRes.builder()
								.companyId(p.getCompanyId().toString())
								.productId(p.getProductId().toString())
								.requestRefNo(p.getRequestReferenceNo())
								.sectionId(p.getSectionId()==null?"":p.getSectionId().toString())
								.vehicleId(p.getVehicleId().toString())
								.searchByData(StringUtils.isBlank(p.getSearchByData())?"":p.getSearchByData())
								.insuranceType(StringUtils.isBlank(p.getInsuranceTypeDesc())?"":p.getInsuranceTypeDesc())
								.insuranceClass(StringUtils.isBlank(p.getInsuranceClassDesc())?"":p.getInsuranceClassDesc())
								.bodyType(StringUtils.isBlank(p.getBodyTypeDesc())?"":p.getBodyTypeDesc())
								.erroDesc(StringUtils.isBlank(p.getErrorDesc())?"":p.getErrorDesc())
								.rowNum(p.getRowNum()==null?"":p.getRowNum().toString())
								.policyStartDate(StringUtils.isBlank(p.getPolicyStartDate())?"":p.getPolicyStartDate())
								.policyEndDate(StringUtils.isBlank(p.getPolicyEndDate())?"":p.getPolicyEndDate())
								.status(p.getStatus())
								.build();	
						arrayList.add(recordsRes);
					});
					res.setCommonResponse(arrayList);
					res.setMessage("SUCCESS");
				}else {
					res.setCommonResponse(null);
					res.setMessage("FAILED");
				}
				
				// employee grid
			}else if("14".equals(req.getProductId()) || "15".equals(req.getProductId()) || "32".equals(req.getProductId())) {
				
				List<EwayEmplyeeDetailRaw> list =new ArrayList<EwayEmplyeeDetailRaw>();
				
				if("E".equalsIgnoreCase(req.getStatus())) {
					list =employeeRawRepo.findByCompanyIdAndProductIdAndRequestReferenceNoAndQuoteNoAndRiskIdAndStatusIgnoreCase(
							Integer.valueOf(req.getCompanyId()),Integer.valueOf(req.getProductId()),req.getRequestRefNo(),
							req.getQuoteNo(),Integer.valueOf(req.getRiskId()),req.getStatus());
				}else if("D".equalsIgnoreCase(req.getStatus())) {
					list =employeeRawRepo.findByCompanyIdAndProductIdAndRequestReferenceNoAndQuoteNoAndRiskIdAndStatusIgnoreCase(
							Integer.valueOf(req.getCompanyId()),Integer.valueOf(req.getProductId()),req.getRequestRefNo(),
							req.getQuoteNo(),Integer.valueOf(req.getRiskId()),req.getStatus());
				
				}else if("Y".equalsIgnoreCase(req.getStatus())) {
					list =employeeRawRepo.findByCompanyIdAndProductIdAndRequestReferenceNoAndQuoteNoAndRiskIdAndStatusIgnoreCase(
							Integer.valueOf(req.getCompanyId()),Integer.valueOf(req.getProductId()),req.getRequestRefNo(),
							req.getQuoteNo(),Integer.valueOf(req.getRiskId()),req.getStatus());
				}
				
				ArrayList<GetEmployeeDetailsRes> arrayList2 =new ArrayList<GetEmployeeDetailsRes>();
				
				if(!CollectionUtils.isEmpty(list)) {
					list.forEach(p ->{
						GetEmployeeDetailsRes recordsRes =GetEmployeeDetailsRes.builder()
								.companyId(p.getCompanyId().toString())
								.productId(p.getProductId().toString())
								.requestRefNo(p.getRequestReferenceNo())
								.nationalityId(StringUtils.isBlank(p.getNationalityId())?"":p.getNationalityId())
								.employeeName(StringUtils.isBlank(p.getEmployeeName())?"":p.getEmployeeName())
								.dateOfBirth(StringUtils.isBlank(p.getDateOfBirth())?"":p.getDateOfBirth())
								.dateOfJoiningYear(StringUtils.isBlank(p.getDateOfJoining())?"":p.getDateOfJoining())
								.dateOfJoiningMonth(StringUtils.isBlank(p.getDateOfJoiningMonth())?"":p.getDateOfJoiningMonth())
								.occupationDesc(StringUtils.isBlank(p.getOccupatonDesc())?"":p.getOccupatonDesc())
								.salary(StringUtils.isBlank(p.getSalary())?"":p.getSalary())
								.occupationId(StringUtils.isBlank(p.getOccupationId())?"":p.getOccupationId())
								.status(p.getStatus())
								.errorDesc(StringUtils.isBlank(p.getErrorDesc())?"":p.getErrorDesc())
								.rowNum(p.getRowNum().toString())
								.quoteNo(p.getQuoteNo())
								.riskId(p.getRiskId().toString())
								.build();	
						arrayList2.add(recordsRes);
					});
					res.setCommonResponse(arrayList2);
					res.setMessage("SUCCESS");
				}else {
					res.setCommonResponse(null);
					res.setMessage("FAILED");
				}
				
			}
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public CommonRes editRecord(EditRecordReq req) {
		CommonRes res = new CommonRes();
		try {
			if("14".equals(req.getProductId()) || "15".equals(req.getProductId()) || "32".equals(req.getProductId())) {
				
				Optional<EwayEmplyeeDetailRaw> raw =employeeRawRepo.findById(Integer.valueOf(req.getRowId()));
				if(raw.isPresent()) {
					EwayEmplyeeDetailRaw p =raw.get();
					GetEmployeeDetailsRes employeeDetailsRes =GetEmployeeDetailsRes.builder()
							.companyId(p.getCompanyId().toString())
							.productId(p.getProductId().toString())
							.requestRefNo(p.getRequestReferenceNo())
							.nationalityId(StringUtils.isBlank(p.getNationalityId())?"":p.getNationalityId())
							.employeeName(StringUtils.isBlank(p.getEmployeeName())?"":p.getEmployeeName())
							.dateOfBirth(StringUtils.isBlank(p.getDateOfBirth())?"":p.getDateOfBirth())
							.dateOfJoiningYear(StringUtils.isBlank(p.getDateOfJoining())?"":p.getDateOfJoining())
							.occupationDesc(StringUtils.isBlank(p.getOccupatonDesc())?"":p.getOccupatonDesc())
							.salary(StringUtils.isBlank(p.getSalary())?"":p.getSalary())
							.status(p.getStatus())
							.errorDesc(StringUtils.isBlank(p.getErrorDesc())?"":p.getErrorDesc())
							.occupationId(StringUtils.isBlank(p.getOccupationId())?"":p.getOccupationId())
							.rowNum(p.getRowNum().toString())
							.quoteNo(p.getQuoteNo())
							.riskId(p.getRiskId().toString())
							.build();
					res.setCommonResponse(employeeDetailsRes);
					res.setMessage("FAILED");
				}else{
					res.setCommonResponse(null);
					res.setMessage("FAILED");
				}
			}
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public CommonRes insertRecords(GetRecordsReq req,String auth) {
		CommonRes res = new CommonRes();
		List<Error> errorList =new ArrayList<Error>();
		try {
			
			if("5".equalsIgnoreCase(req.getProductId())) {
				List<EserviceMotorDetailsRaw> list =eserviceRepository.findByCompanyIdAndProductIdAndRequestReferenceNo(Integer.valueOf(req.getCompanyId()),Integer.valueOf(req.getProductId()),
						req.getRequestRefNo());
				if(!CollectionUtils.isEmpty(list)) {
					// filter error records
					Long count =list.stream()
							.filter(p -> "E".equalsIgnoreCase(p.getStatus()))
							.count();
					if(count==0) {
						// filter valid records
						List<EserviceMotorDetailsRaw> data =list.stream()
								.filter(p -> "Y".equalsIgnoreCase(p.getStatus()))
								.collect(Collectors.toList());
						
						// made the partitions based by 10
						List<List<EserviceMotorDetailsRaw>> partitions =nPartition(data, data.size()>10?data.size()/6:10);
						
						for(List<EserviceMotorDetailsRaw> eservice :partitions) {
							
							List<CompletableFuture<Object>> comFuture=eservice.stream()
									.map(p ->asyncProcess.createQuote(p,auth))
									.collect(Collectors.toList());
								
							@SuppressWarnings("unchecked")
							CompletableFuture<Object>[] comArray =new CompletableFuture[comFuture.size()];
							comFuture.toArray(comArray);
							CompletableFuture.allOf(comArray).join();
							
						}
						
						res.setCommonResponse("SUCCESS");
						res.setMessage("SUCCESS");
					}else {
						
						errorList.add(new Error("100","Error","Please kindly update error records or delete error records"));
						res.setErrorMessage(errorList);
						res.setMessage("ERROR");
						return res;
					}
				}else {
					res.setCommonResponse("FAILED");
					res.setMessage("FAILED");
				}
		}
			
		else if("14".equals(req.getProductId()) || "15".equals(req.getProductId()) || "32".equals(req.getProductId())) {
			
			List<EwayEmplyeeDetailRaw> list =employeeRawRepo.findByCompanyIdAndProductIdAndRequestReferenceNo(Integer.valueOf(req.getCompanyId()),Integer.valueOf(req.getProductId()),
					req.getRequestRefNo());
			if(!CollectionUtils.isEmpty(list)) {
				// filter error records
				Long count =list.stream()
						.filter(p -> "E".equalsIgnoreCase(p.getStatus()))
						.count();
				if(count==0) {
					// filter valid records
					List<EwayEmplyeeDetailRaw> data =list.stream()
							.filter(p -> "Y".equalsIgnoreCase(p.getStatus()))
							.collect(Collectors.toList());
					
					// made the partitions based by 10
					List<List<EwayEmplyeeDetailRaw>> partitions_list =nPartition(data, data.size()/5);
					
					for (List<EwayEmplyeeDetailRaw> e : partitions_list) {
						
						//parallel calling
						List<CompletableFuture<String>> comFutures =e.parallelStream()
								.map(m -> asyncProcess.createEmployee(m,auth))
								.collect(Collectors.toList());
						
						@SuppressWarnings("unchecked")
						CompletableFuture<Object> [] coFuturesArray =new CompletableFuture [comFutures.size()];
						comFutures.toArray(coFuturesArray);
						CompletableFuture.allOf(coFuturesArray).join();
					}	
					
					res.setCommonResponse("SUCCESS");
					res.setMessage("SUCCESS");
				}else {
					
					errorList.add(new Error("100","Error","Please kindly update error records or delete error records"));
					res.setErrorMessage(errorList);
					res.setMessage("ERROR");
					return res;
				}
			}else {
				res.setCommonResponse("FAILED");
				res.setMessage("FAILED");
			}
			
		}
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public CommonRes updateRecords(UpdateRecordReq req) {
		CommonRes res = new CommonRes();
		try {
			if("14".equals(req.getProductId()) || "15".equals(req.getProductId()) || "32".equals(req.getProductId())) {				
				List<Error> errorList=validation.validateEmployee(req);
				if(CollectionUtils.isEmpty(errorList)) {
					Optional<EwayEmplyeeDetailRaw> emp =employeeRawRepo.findById(Integer.valueOf(req.getRowNum()));
					if(emp.isPresent()) {
						EwayEmplyeeDetailRaw detailRaw =emp.get();
						detailRaw.setEmployeeName(req.getEmployeeName());
						detailRaw.setDateOfBirth(req.getDateOfBirth());
						detailRaw.setDateOfJoining(req.getDateOfJoiningYear());
						detailRaw.setDateOfJoiningMonth(req.getDateOfJoiningMonth());
						detailRaw.setNationalityId(req.getNationalityId());
						detailRaw.setOccupationId(req.getOccupationId());
						detailRaw.setOccupatonDesc(req.getOccupationDesc());
						detailRaw.setSalary(req.getSalary());
						detailRaw.setStatus("Y");
						detailRaw.setErrorDesc("");
						EwayEmplyeeDetailRaw result =employeeRawRepo.saveAndFlush(detailRaw);
						Integer count =employeeRawRepo.checkSuminsuredValidation(req.getQuoteNo(), req.getRequestRefNo(), req.getCompanyId(),
								req.getRiskId(), req.getProductId());
						if(result!=null && count ==0) {
							
							TransactionControlDetails tDetails=	transRepo.findByCompanyIdAndProductIdAndRequestReferenceNo(Integer.valueOf(req.getCompanyId()),
									Integer.valueOf(req.getProductId()), req.getRequestRefNo());
							Integer validRecords =tDetails.getValidRecords();
							Integer errorRecords =tDetails.getErrorRecords();
							tDetails.setErrorRecords(errorRecords-1);
							tDetails.setValidRecords(validRecords+1);
							transRepo.saveAndFlush(tDetails);
						}
						
						res.setCommonResponse("SUCCESS");
						res.setMessage("SUCCESS");
					}else {
						
						res.setCommonResponse("FAILED");
						res.setMessage("FAILED");
					}
				}else {
					res.setCommonResponse(errorList);
					res.setMessage("ERROR");
				}
				
			}
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		return res;
	}

	private String getRequestRefNo(String companyId,String branchCode,String productId) {
		String refNo ="";
		try {
			String refCode=requestRefNo.getListItem(companyId, branchCode, "PRODUCT_SHORT_CODE", productId);
			refNo =refCode +"-" + sequence.generateRefNo() ; 
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		
		return refNo;
	}

	@Override
	public CommonRes deleteRecords(DeleteRecordReq req) {
		CommonRes res = new CommonRes();
		try {
			if("5".equals(req.getProductId())) {
				Integer count =eserviceRepository.deleteByRowNum(Integer.valueOf(req.getRowNUm()));
				if(count>0) {
					res.setMessage("SUCCESS");
					res.setCommonResponse("SUCCESS");
				}else {
					res.setMessage("FAILED");
					res.setCommonResponse("FAILED");
				}
			}
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			res.setMessage("Exception");
			res.setCommonResponse("Somthing went wrong contact Admin...!");
		}
		return res;
	}

	@Override
	public CommonRes sampleDownload(SamplFileDownloadReq req) {
		CommonRes res =new CommonRes();
		try {
			EwayUploadTypeMaster typeMaster =uploadTypeRepo.findByCompanyIdAndProductIdAndTypeidAndStatus(Integer.valueOf(req.getCompanyId()),Integer.valueOf(req.getProductId())
					,Integer.valueOf(req.getProductId()),"Y");
			String file_path =typeMaster.getFilePath();
			String dataUri ="data:application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;base64,";
			File file =new File(file_path);
			if(file.exists()) {
				byte array []=FileUtils.readFileToByteArray(file);
				String encodeString =Base64.getEncoder().encodeToString(array);
				res.setMessage("SUCCESS");
				res.setCommonResponse(dataUri+encodeString);
			}else {
				res.setMessage("FAILED");
				res.setCommonResponse("File not found ... Cotact Admin....!");
			}
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		return res;
	}
}
