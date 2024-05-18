package com.maan.claim.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.maan.claim.entity.AccidentInfo;
import com.maan.claim.entity.ActInfo;
import com.maan.claim.error.Error;
import com.maan.claim.repository.AccidentInfoRepository;
import com.maan.claim.repository.ActInfoRepository;
import com.maan.claim.req.AccidentInfoSaveReq;
import com.maan.claim.req.ActEditReq;
import com.maan.claim.req.ActGridReq;
import com.maan.claim.req.ActSaveReq;

import com.maan.claim.res.AccidentInfoRes;
import com.maan.claim.res.ActInfoRes;

import com.maan.claim.res.SuccessRes;
import com.maan.claim.service.ActInfoService;



@Service
public class ActInfoServiceImpl implements ActInfoService {

	@Autowired
	private ActInfoRepository repository;

	@Autowired
	private AccidentInfoRepository accidentRepo;

	private Logger log = LogManager.getLogger(ActInfoServiceImpl.class);
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
	Gson json = new Gson();

	@Override
	public List<ActInfoRes> getActDetails() {
		List<ActInfoRes> resList = new ArrayList<ActInfoRes>();
		try {
			List<ActInfo> actDetails = repository.findAll();
			// actDetails.forEach(data ->

			for (ActInfo data : actDetails) {
				ActInfoRes res = new ActInfoRes();
				res.setActarabic(data.getActarabic());
				res.setActenglish(data.getActenglish());
				res.setCasenumber(data.getCasenumber());
				res.setEntryDate(data.getEntrydate() == null ? "" : sdf.format(data.getEntrydate()));
				res.setRemarks(data.getRemarks());
				res.setSequenceNumber(data.getSequencenumber() == null ? "" : data.getSequencenumber().toString());
				res.setStatus(data.getStatus());
				res.setVehicleId(data.getVehicleid() == null ? "" : data.getVehicleid().toString());

				resList.add(res);
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;

		}
		return resList;
	}

	@Override
	public ActInfoRes getActInfo(String id) {
		ActInfoRes res = new ActInfoRes();
		try {
			ActInfo data = repository.findBySequencenumber(new BigDecimal(id));

			res.setActarabic(data.getActarabic());
			res.setActenglish(data.getActenglish());
			res.setCasenumber(data.getCasenumber());
			res.setEntryDate(data.getEntrydate() == null ? "" : sdf.format(data.getEntrydate()));
			res.setRemarks(data.getRemarks());
			res.setSequenceNumber(data.getSequencenumber() == null ? "" : data.getSequencenumber().toString());
			res.setStatus(data.getStatus());
			res.setVehicleId(data.getVehicleid() == null ? "" : data.getVehicleid().toString());

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;

		}
		return res;
	}

	@Override
	public ActInfoRes getActDetailsById(ActEditReq req) {
		ActInfoRes res = new ActInfoRes();
		ModelMapper mapper = new ModelMapper();
		try {
			ActInfo data = repository.findBySequencenumber(new BigDecimal(req.getSequencenumber()));

			res = mapper.map(data, ActInfoRes.class);
			res.setEntryDate(data.getEntrydate() == null ? "" : sdf.format(data.getEntrydate()));

			/*
			 * res.java.lang.String(data.getActarabic());
			 * res.setActenglish(data.getActenglish());
			 * res.setCasenumber(data.getCasenumber());
			 * res.setEntryDate(data.getEntrydate()==null?"":sdf.format(data.getEntrydate())
			 * ); res.setRemarks(data.getRemarks());
			 * res.setSequenceNumber(data.getSequencenumber() == null?"":
			 * data.getSequencenumber().toString()); res.setStatus(data.getStatus());
			 * res.setVehicleId(data.getVehicleid()==null?"":data.getVehicleid().toString())
			 * ;
			 */

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;

		}
		return res;
	}

	@Override
	@Transactional
	public SuccessRes saveActDetails(ActSaveReq req) {
		SuccessRes res = new SuccessRes();
		ModelMapper mapper = new ModelMapper();
		try {
			ActInfo saveAct = new ActInfo();

			BigDecimal sequenceNumber = BigDecimal.ZERO;
			Date entryDate = null;

			if (StringUtils.isBlank(req.getSequencenumber())) {

				// Save
				// (i)
				Long totlaRecord = repository.count();
				sequenceNumber = new BigDecimal(totlaRecord + 1);
				entryDate = new Date();
				// (ii)
				/*
				 * List<ActInfo> findAllData = repository.OrderBySequencenumberDesc(); entryDate
				 * = new Date();
				 * 
				 * if(findAllData==null && findAllData.size()==0 ) sequenceNumber =
				 * BigDecimal.ONE; else sequenceNumber =
				 * findAllData.get(0).getSequencenumber().add(BigDecimal.ONE) ;
				 */
				res.setResponse("Saved Succesfully");
			} else {
				// Update
				sequenceNumber = new BigDecimal(req.getSequencenumber());
				ActInfo findData = repository.findBySequencenumber(sequenceNumber);
				entryDate = findData.getEntrydate();

				res.setResponse("Updated Succesfully");
			}
			req.setEffectiveDate(dbFormat.format(sdf.parse(req.getEffectiveDate())));

			saveAct = mapper.map(req, ActInfo.class);
			saveAct.setSequencenumber(sequenceNumber);
			saveAct.setEntrydate(entryDate);
			saveAct.setStatus("Y");

			repository.save(saveAct);
			log.info("Saved Details is ---> " + json.toJson(saveAct));

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;

		}
		return res;
	}

	@Override
	public List<Error> validateActDetailsReq(ActSaveReq req) {
		List<Error> errors = new ArrayList<Error>();
		try {
			if (StringUtils.isBlank(req.getActarabic())) {
				errors.add(new Error("01", "Act Arabic", "Please Enter Act Arabic"));
			} else if (!req.getActarabic().matches("[a-zA-Z.]+")) {
				errors.add(new Error("01", "Act Arabic", "Please Enter Valid Act Arabic"));
			}
			Date today = new Date();
			if (StringUtils.isBlank(req.getEffectiveDate()))
				errors.add(new Error("10", "Driver Dob", "please enter valid Effective Date Of Birth"));
			else if (!req.getEffectiveDate().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"))
				errors.add(new Error("10", "Driver Dob",
						"Effective Date format should be dd/MM/yyyy only allowed . Example :- 15/12/2020"));
			else if (sdf.parse(req.getEffectiveDate()).before(today))
				errors.add(new Error("10", "Driver Dob", "Effective Date Before Today Not Allowed"));

			if (StringUtils.isBlank(req.getCasenumber())) {
				errors.add(new Error("01", "Act Arabic", "Please Enter Case Number"));
			} else if (!req.getCasenumber().matches("[0-9]+")) {
				errors.add(new Error("01", "Act Arabic", "Please Enter Valid Case Number"));
			} else if (req.getCasenumber().length() > 10) {
				errors.add(new Error("01", "Act Arabic", "Case Number UNDER 10 DIGIT ONY ALLOWED"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			errors.add(new Error("01", "Common Error", e.getMessage()));

		}
		return errors;
	}

	@Override
	public List<Error> validateListOfActDetailsReq(List<ActSaveReq> req) {
		List<Error> errors = new ArrayList<Error>();
		try {

			// List Validation
			Long row = 0l;
			for (ActSaveReq data : req) {

				row = row + 1;
				if (StringUtils.isBlank(data.getActarabic())) {
					errors.add(new Error("01", "Act Arabic", "Please Enter Act Arabic in Row :" + row));
				} else if (!data.getActarabic().matches("[a-zA-Z.]+")) {
					errors.add(new Error("01", "Act Arabic", "Please Enter Valid Act Arabic in Row :" + row));
				}
				Date today = new Date();
				if (StringUtils.isBlank(data.getEffectiveDate()))
					errors.add(
							new Error("10", "Driver Dob", "please enter valid Effective Date Of Birth in Row :" + row));
				else if (!data.getEffectiveDate().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"))
					errors.add(new Error("10", "Driver Dob",
							"Effective Date format should be dd/MM/yyyy only allowed . Example :- 15/12/2020in Row :"
									+ row));
				else if (sdf.parse(data.getEffectiveDate()).before(today))
					errors.add(new Error("10", "Driver Dob", "Effective Date Before Today Not Allowedin Row :" + row));

				if (StringUtils.isBlank(data.getCasenumber())) {
					errors.add(new Error("01", "Act Arabic", "Please Enter Case Numberin Row :" + row));
				} else if (!data.getCasenumber().matches("[0-9]+")) {
					errors.add(new Error("01", "Act Arabic", "Please Enter Valid Case Numberin Row :" + row));
				} else if (data.getCasenumber().length() > 10) {
					errors.add(new Error("01", "Act Arabic", "Case Number UNDER 10 DIGIT ONY ALLOWEDin Row :" + row));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			errors.add(new Error("01", "Common Error", e.getMessage()));

		}
		return errors;
	}

	@Override
	@Transactional
	public SuccessRes saveListOfActDetails(List<ActSaveReq> req) {
		SuccessRes res = new SuccessRes();
		ModelMapper mapper = new ModelMapper();
		try {
			for (ActSaveReq data : req) {

				ActInfo saveAct = new ActInfo();
				BigDecimal sequenceNumber = BigDecimal.ZERO;
				BigDecimal vehicleId = new BigDecimal(data.getVehicleid());
				Date entryDate = null;

				if (StringUtils.isBlank(data.getSequencenumber())) {

					// Save
					// (i)
					/*
					 * Long totlaRecord = repository.count(); sequenceNumber = new BigDecimal(
					 * totlaRecord +1) ;
					 */

					// (ii)
					List<ActInfo> findAllData = repository.OrderBySequencenumberDesc();
					entryDate = new Date();

					if (findAllData == null && findAllData.size() == 0)
						sequenceNumber = BigDecimal.ONE;
					else
						sequenceNumber = findAllData.get(0).getSequencenumber().add(BigDecimal.ONE);

				} else {
					// Update
					sequenceNumber = new BigDecimal(data.getSequencenumber());
					ActInfo findData = repository.findBySequencenumber(sequenceNumber);
					saveAct = findData; /// Update Query
					entryDate = findData.getEntrydate();

				}

				data.setEffectiveDate(dbFormat.format(sdf.parse(data.getEffectiveDate())));

				saveAct = mapper.map(data, ActInfo.class);
				saveAct.setVehicleid(vehicleId);
				saveAct.setSequencenumber(sequenceNumber);
				saveAct.setEntrydate(entryDate);
				repository.save(saveAct);
				log.info("Saved Details is ---> " + json.toJson(saveAct));
			}
			res.setResponse("List Saved Succesfully");

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;

		}
		return res;
	}

	@Override
	public ActInfoRes getActDetailsByIdWithList(ActEditReq req) {
		ActInfoRes response = new ActInfoRes();
		ModelMapper mapper = new ModelMapper();
		try {
			ActInfo findData = repository.findBySequencenumber(new BigDecimal(req.getSequencenumber()));
			String caseNumber = findData.getCasenumber();

			List<AccidentInfo> accDatas = accidentRepo.findByCityidOrderByEntrydateDesc(caseNumber);

			// Sorting Acsending
			accDatas.sort(Comparator.comparing(AccidentInfo::getAmendid));

			// Sorting Desending
			accDatas.sort(Comparator.comparing(AccidentInfo::getAmendid).reversed());

			AccidentInfoRes accidentData = new AccidentInfoRes();
			accidentData = mapper.map(accDatas.get(0), AccidentInfoRes.class);
			accidentData.setEntrydate(
					accDatas.get(0).getEntrydate() == null ? "" : sdf.format(accDatas.get(0).getEntrydate()));

			// (i)
			/*
			 * List<AccidentInfoRes> accidentList = new ArrayList<AccidentInfoRes>() ; Type
			 * listType = new TypeToken<List<AccidentInfoRes>>(){}.getType(); accidentList =
			 * mapper.map(accDatas,listType);
			 */

			// (ii)
			List<AccidentInfoRes> accidentList = new ArrayList<AccidentInfoRes>();

			for (AccidentInfo data : accDatas) {
				AccidentInfoRes res = new AccidentInfoRes();
				res.setSurveyorname(data.getSurveyorname());
				res.setCalldate(data.getCalldate() == null ? "" : sdf.format(data.getCalldate()));
				res.setCalltime(data.getCalltime());
				res.setLandmark(data.getLandmark());
				res.setLocation(data.getLocation());
				res.setLocationcoordinates(data.getLocationcoordinates());
				res.setCityid(data.getCityid());
				res.setLocation(data.getLocation());
				res.setCity(data.getCity());
				res.setAccidentdescription(data.getAccidentdescription());
				res.setEntrydate(data.getEntrydate() == null ? "" : sdf.format(data.getEntrydate()));
				res.setAmendid(data.getAmendid() == null ? "" : data.getAmendid().toString());
				res.setStatus(data.getStatus());

				accidentList.add(res);
			}

			// 1 st table
			response = mapper.map(findData, ActInfoRes.class);
			response.setEntryDate(findData.getEntrydate() == null ? "" : sdf.format(findData.getEntrydate()));

			// 2 nd table 1 data
			response.setAccidentData(accidentData);

			// 2nd table list of data
			response.setAccidentList(accidentList);

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;

		}
		return response;
	}

	@Override
	public SuccessRes saveActDetailsWithAccidentList(ActSaveReq req) {
		SuccessRes res = new SuccessRes();
		ModelMapper mapper = new ModelMapper();
		try {
			// Table 1 : Single Data
			ActInfo saveAct = new ActInfo();
			BigDecimal sequenceNumber = BigDecimal.ZERO;
			Date entryDate = null;

			if (StringUtils.isBlank(req.getSequencenumber())) {
				// Save
				// (i)
				Long totlaRecord = repository.count();
				sequenceNumber = new BigDecimal(totlaRecord + 1);
				entryDate = new Date();

				res.setResponse("Saved Succesfully");
			} else {
				// Update
				sequenceNumber = new BigDecimal(req.getSequencenumber());
				ActInfo findData = repository.findBySequencenumber(sequenceNumber);
				entryDate = findData.getEntrydate();

				res.setResponse("Updated Succesfully");
			}
			req.setEffectiveDate(dbFormat.format(sdf.parse(req.getEffectiveDate())));

			saveAct = mapper.map(req, ActInfo.class);
			saveAct.setSequencenumber(sequenceNumber);
			saveAct.setEntrydate(entryDate);
			saveAct.setStatus("Y");

			repository.save(saveAct);
			log.info("Saved Details is ---> " + json.toJson(saveAct));

			// Table 2 : List Of Data
			for (AccidentInfoSaveReq data : req.getAccidenttList()) {

				AccidentInfo saveAccidentList = new AccidentInfo();
				BigDecimal caseNumber = new BigDecimal("0");

				if (StringUtils.isBlank(data.getCaseNumber())) {

					Long totalCount = accidentRepo.count();
					entryDate = new Date();
					caseNumber = new BigDecimal(totalCount + 1);

				} else {
					// Update
					caseNumber = new BigDecimal(data.getCaseNumber());
					AccidentInfo findData = accidentRepo.findByCasenumber(caseNumber);
					saveAccidentList = findData; /// Update Query
					entryDate = findData.getEntrydate();
				}

				saveAccidentList = mapper.map(data, AccidentInfo.class);
				saveAccidentList.setCasenumber(caseNumber);
				saveAccidentList.setEntrydate(entryDate);
				accidentRepo.save(saveAccidentList);
				log.info("Saved Details is ---> " + json.toJson(saveAccidentList));
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;

		}
		return res;
	}

	@Override
	public List<Error> validateActDetailsWithAccidentList(ActSaveReq req) {
		List<Error> errors = new ArrayList<Error>();
		try {

			// Table 1 : Single Data
			if (StringUtils.isBlank(req.getActarabic())) {
				errors.add(new Error("01", "Act Arabic", "Please Enter Act Arabic"));
			} else if (!req.getActarabic().matches("[a-zA-Z.]+")) {
				errors.add(new Error("01", "Act Arabic", "Please Enter Valid Act Arabic"));
			}
			Date today = new Date();
			if (StringUtils.isBlank(req.getEffectiveDate()))
				errors.add(new Error("10", "Driver Dob", "please enter valid Effective Date Of Birth"));
			else if (!req.getEffectiveDate().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"))
				errors.add(new Error("10", "Driver Dob",
						"Effective Date format should be dd/MM/yyyy only allowed . Example :- 15/12/2020"));
			else if (sdf.parse(req.getEffectiveDate()).before(today))
				errors.add(new Error("10", "Driver Dob", "Effective Date Before Today Not Allowed"));

			if (StringUtils.isBlank(req.getCasenumber())) {
				errors.add(new Error("01", "Act Arabic", "Please Enter Case Number"));
			} else if (!req.getCasenumber().matches("[0-9]+")) {
				errors.add(new Error("01", "Act Arabic", "Please Enter Valid Case Number"));
			} else if (req.getCasenumber().length() > 10) {
				errors.add(new Error("01", "Act Arabic", "Case Number UNDER 10 DIGIT ONY ALLOWED"));
			}

			// Table 2 : List data
			if (req.getAccidenttList() == null || req.getAccidenttList().size() <= 0) {
				errors.add(new Error("01", "Accident Details", "Please Add atleast one Accident Data  "));
			} else {
				Long row = 0l;
				for (AccidentInfoSaveReq data : req.getAccidenttList()) {

					row = row + 1;
					if (StringUtils.isBlank(data.getAccidentdescription())) {
						errors.add(new Error("01", "Act Arabic", "Please Enter Act Arabic in Row :" + row));
					} else if (!data.getAccidentdescription().matches("[a-zA-Z.]+")) {
						errors.add(new Error("01", "Act Arabic", "Please Enter Valid Act Arabic in Row :" + row));
					}
					/*
					 * Date today = new Date() ; if(StringUtils.isBlank(data.getEffectiveDate()))
					 * errors.add(new
					 * Error("10","Driver Dob","please enter valid Effective Date Of Birth in Row :"
					 * + row )); else if(!
					 * data.getEffectiveDate().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})") )
					 * errors.add(new Error("10","Driver Dob"
					 * ,"Effective Date format should be dd/MM/yyyy only allowed . Example :- 15/12/2020in Row :"
					 * + row )); else if(sdf.parse(data.getEffectiveDate()).before(today) )
					 * errors.add(new
					 * Error("10","Driver Dob","Effective Date Before Today Not Allowedin Row :" +
					 * row ));
					 */
					if (StringUtils.isBlank(data.getCityid())) {
						errors.add(new Error("01", "Act Arabic", "Please Enter Case Numberin Row :" + row));
					} else if (!data.getCityid().matches("[0-9]+")) {
						errors.add(new Error("01", "Act Arabic", "Please Enter Valid Case Numberin Row :" + row));
					} else if (data.getCityid().length() > 10) {
						errors.add(
								new Error("01", "Act Arabic", "Case Number UNDER 10 DIGIT ONY ALLOWEDin Row :" + row));
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			errors.add(new Error("01", "Common Error", e.getMessage()));

		}
		return errors;
	}
//pagination 
	@Override
	public List<ActInfoRes> getActDetails2(ActGridReq req) {
		List<ActInfoRes> resList = new ArrayList<ActInfoRes>();
		try {
			int limit = StringUtils.isBlank(req.getLimit()) ? 0 : Integer.valueOf(req.getLimit());
			int offset = StringUtils.isBlank(req.getOffset()) ? 10 : Integer.valueOf(req.getOffset());

			// Pageable paging = PageRequest.of(Integer.valueOf(req.getLimit()),
			// Integer.valueOf(req.getOffset()),Sort.by("entryDate").descending());

			Pageable paging = PageRequest.of(limit, offset, Sort.by("entrydate").descending());
			// (i)
			
			// Page<ActInfo> actDetails = repository.findAll(paging);
			Page<ActInfo> actDetails = repository.findByStatus(paging, "Y"); 
			
			
			
		//	List<Map<String,Object>> quoteList = repository.getPortFolio(insuranceid ,  );
			
			// List<ActInfo> actDetails = repository.findAll();

			/*
			 * Page<HomePositionMaster> opt2=repository.findAll(paging);
			 * List<HomePositionMaster> opt =opt2.getContent();
			 */
			// (ii)
			//actDetails.getContent().forEach(data ->
			//for (Map<String,Object> data : quoteList){
			for (ActInfo data : actDetails.getContent()) { 
		
				ActInfoRes res = new ActInfoRes();
				res.setActarabic(data.getActarabic());
				res.setActenglish(data.getActenglish());
				res.setCasenumber(data.getCasenumber());
				res.setEntryDate(data.getEntrydate() == null ? "" : sdf.format(data.getEntrydate()));
				res.setRemarks(data.getRemarks());
				res.setSequenceNumber(data.getSequencenumber() == null ? "" : data.getSequencenumber().toString());
				res.setStatus(data.getStatus());
				res.setVehicleId(data.getVehicleid() == null ? "" : data.getVehicleid().toString());

				resList.add(res);
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;

		}
		return resList;
		}

	
/*	@Override
	public List<ExistingQuoteGridRes> getAllExistingQuote(ExistingQuoteGridReq req) {
		List<ExistingQuoteGridRes> resList = new ArrayList<ExistingQuoteGridRes>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			List<Map<String, Object>> existingQuoteList = new ArrayList<Map<String, Object>>(); 
			
			int limit  = StringUtils.isBlank(req.getLimit()) ? 0 : Integer.valueOf(req.getLimit());
			int offset = StringUtils.isBlank(req.getOffset()) ? 10 : Integer.valueOf(req.getOffset());

			// Between 
			int start  =  limit * offset + 1 ; 
			int end    =  limit * offset + offset;
			
			if(req.getApplicationId().equalsIgnoreCase("1")) {
				// Broker  
				existingQuoteList = repository.getBrokerExistingQuoteDetails(req.getLoginId(),req.getProductId(), req.getApplicationId(),req.getOpenCoverNo(), req.getSalesTurnOverType(), req.getConsolidatePolicyNo(), start ,end);
				
			} else {
				// Issuer  
				existingQuoteList = repository.getExistingQuoteDetails(req.getLoginId(),req.getProductId(), req.getApplicationId(),req.getOpenCoverNo(), req.getSalesTurnOverType(), req.getConsolidatePolicyNo(), start ,end);
			}
			
			// Without Pagination
		/*  List<Map<String, Object>> existingQuoteList = repository.getExistingQuoteDetails(req.getLoginId(),req.getProductId(), req.getApplicationId(),req.getOpenCoverNo(), req.getSalesTurnOverType(), req.getConsolidatePolicyNo(), start ,end); */	
			
		/*	for (Map<String, Object> data : existingQuoteList) {
				ExistingQuoteGridRes res = new ExistingQuoteGridRes();

				res.setApplicationId(data.get("APPLICATION_NO") == null ? "" : data.get("APPLICATION_NO").toString());
				res.setCompanyName(data.get("COMPANY_NAME") == null ? "" : data.get("COMPANY_NAME").toString());
				res.setCustomerId(data.get("CUSTOMER_ID") == null ? "" : data.get("CUSTOMER_ID").toString());
				res.setCustomerName(data.get("CUSTOMER_NAME") == null ? "" : data.get("CUSTOMER_NAME").toString());
				res.setEffectiveDate(data.get("QUOTE_NO") == null ? "" : data.get("QUOTE_NO").toString());
				res.setEffectiveDate(data.get("EFFECTIVE_DATE") == null ? "" : sdf.format(data.get("EFFECTIVE_DATE")));
				res.setEmail(data.get("EMAIL") == null ? "" : data.get("EMAIL").toString());
				res.setLoginId(data.get("LOGIN_ID") == null ? "" : data.get("LOGIN_ID").toString());
				res.setOpenCoverNo(data.get("OPEN_COVER_NO") == null ? "" : data.get("OPEN_COVER_NO").toString());
				res.setPremium(data.get("PREMIUM") == null ? "" : data.get("PREMIUM").toString());
				res.setQuotationDate(data.get("QUOTATION_DATE") == null ? "" : data.get("QUOTATION_DATE").toString());
				res.setQuoteNo(data.get("QUOTE_NO") == null ? "" : data.get("QUOTE_NO").toString());
				res.setValidityDate(data.get("VALIDITY_DATE") == null ? "" : data.get("VALIDITY_DATE").toString());

				resList.add(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is ---> " + e.getMessage());
			return null;
		}
		return resList;
	}
 */
/*
// Policy Nominee Details Save
		@Override
		public PolicySuccessRes savePolicyNominee(PolicyNomineeDetailsSaveReq req) {
			PolicySuccessRes res = new PolicySuccessRes();

			ModelMapper mapper = new ModelMapper();
			try {
				PolicyNomineeDetailsId id = new PolicyNomineeDetailsId();

				id.setNomineeId(req.getNomineeId());
				id.setPolicyId(req.getPolicyId());
				
				Optional<PolicyNomineeDetails> data = policydetailsrepository.findById(id);
				if (data.isPresent()) {
					// Update
					PolicyNomineeDetails ent = mapper.map(req, PolicyNomineeDetails.class);
					ent.setNomineeId(req.getNomineeId());
					
					policydetailsrepository.save(ent);
					res.setResponse("Updated Successfully ");

				} else {

					// Insert
					List<PolicyNomineeDetails> list = policydetailsrepository.findAllByOrderByNomineeIdDesc();
					Integer nomineeId = 1000;

					if (list.size() != 0) {
						nomineeId = list.get(0).getNomineeId()+ 1;
					}
					PolicyNomineeDetails ent = mapper.map(req, PolicyNomineeDetails.class);
					ent.setNomineeId(nomineeId);;
					policydetailsrepository.save(ent);

					res.setResponse("Inserted Successfully ");
				}

			} catch (Exception ex) {
				log.error(ex);
				return null;
			}
			return res;
		}	


		
		/// Policy Nominee Details Get by nominee id
		@Override
		public PolicyNomineeDetailsRes getPolicyNominee(PolicyNomineeDetailsGetReq req) {
			PolicyNomineeDetailsRes res = new PolicyNomineeDetailsRes();
			try {

				PolicyNomineeDetailsId id = new PolicyNomineeDetailsId();
				id.setNomineeId(req.getNomineeId());
				id.setPolicyId(req.getPolicyId());				
								
				Optional<PolicyNomineeDetails> opt = policydetailsrepository.findById(id);

				if (opt.isPresent()) {

					ModelMapper modelMapper = new ModelMapper();
					res = modelMapper.map(opt.get(), PolicyNomineeDetailsRes.class);

				}
			} catch (Exception e) {
				res = null;
				log.info("Exception Error", e.getMessage());
			}
			return res;
		}

 */
}
