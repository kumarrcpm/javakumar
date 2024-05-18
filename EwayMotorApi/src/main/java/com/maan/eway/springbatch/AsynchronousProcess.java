package com.maan.eway.springbatch;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.maan.eway.batch.entity.EserviceMotorDetailsRaw;
import com.maan.eway.batch.entity.EwayEmplyeeDetailRaw;
import com.maan.eway.batch.repository.EserviceMotorDetailsRawRepository;
import com.maan.eway.res.CommonRes;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


@Component
public class AsynchronousProcess {
	
	
	Logger log =LogManager.getLogger(AsynchronousProcess.class);
	
	@Value("${tira.api}")
	private String tiraApi;
	
	@Value("${save.vehicle.api}")
	private String vehicleApi;
	
	@Value("${premium.calc.api}")
	private String calcApi;
	
	@Value("${employee.save.api}")
	private String employeeSaveApi;
	
	@Autowired
	private EserviceMotorDetailsRawRepository eserviceRepository;
	
    private static ObjectMapper mapper =new ObjectMapper();
    
    private static Gson print =new Gson();
    
    OkHttpClient httpClient =new OkHttpClient.Builder()
			.connectTimeout(30, TimeUnit.SECONDS)
			.build();
	


	@Async
	public CompletableFuture<String> validateTira(EserviceMotorDetailsRaw rawData, EwayUploadRes uploadResponse){
		String response ="";
		try {
			log.info("Thread Name :"+Thread.currentThread().getName());
			String searchByValue =StringUtils.isBlank(rawData.getTiraSearchByDesc())?"":rawData.getTiraSearchByDesc().replaceAll("\\s", "");
			String regNo ="RegistrationNumber".equalsIgnoreCase(searchByValue)?rawData.getSearchByData():"";
			String chassisNo ="ChassisNumber".equalsIgnoreCase(searchByValue)?rawData.getSearchByData():"";
			String josnString ="{\"ReqRegNumber\":\"{REG_NO}\",\"ReqChassisNumber\":\"{CHASSIS_NO}\"}";
			String request =josnString.replace("{REG_NO}", regNo).replace("{CHASSIS_NO}", chassisNo);
			log.info("Tira request :" +request);
			
			OkHttpClient httpClient =new OkHttpClient.Builder()
					.connectTimeout(30L, TimeUnit.SECONDS)
					.readTimeout(30L,TimeUnit.SECONDS)
					.writeTimeout(30L, TimeUnit.SECONDS)
					.build();
			
			okhttp3.MediaType content_type = okhttp3.MediaType.parse("application/json");
			@SuppressWarnings("deprecation")
			RequestBody body = RequestBody.create(content_type,request);
			
			
			Request req =new Request.Builder()
					.addHeader("Authorization", "Bearer "+uploadResponse.getToken())
					.url(tiraApi)
					.post(body)
					.build();
			
			Response res =httpClient.newCall(req).execute();
			String resString =res.body().string();
			log.info("Tira response :" +resString);
			CommonRes map =mapper.readValue(resString, CommonRes.class);
			if(CollectionUtils.isEmpty(map.getErrorMessage())) {
				@SuppressWarnings("unchecked")
				Map<String,Object> d =(Map<String,Object>) map.getCommonResponse();
				rawData.setAxelDistance(d.get("AxelDistance")==null?"0":d.get("AxelDistance").toString());
				rawData.setColor(d.get("Color")==null?"":d.get("Color").toString());
				rawData.setCreatedBy(d.get("CreatedBy")==null?"":d.get("CreatedBy").toString());
				rawData.setEngineNumber(d.get("EngineNumber")==null?"":d.get("EngineNumber").toString());
				rawData.setFuelType(d.get("FuelType")==null?"":d.get("FuelType").toString());
				rawData.setGrossWeight(d.get("Grossweight")==null?"":d.get("Grossweight").toString());
				rawData.setManufactureYear(d.get("ManufactureYear")==null?"":d.get("ManufactureYear").toString());
				rawData.setMotorCategory(d.get("MotorCategory")==null?"":d.get("MotorCategory").toString());
				rawData.setNumberOfAxels(d.get("NumberOfAxels")==null?"0":d.get("NumberOfAxels").toString());
				rawData.setOwnerCategory(d.get("OwnerCategory")==null?"":d.get("OwnerCategory").toString());
				rawData.setPolicyYn(d.get("PolicyYn")==null?"":d.get("PolicyYn").toString());
				rawData.setReqChassisNo(d.get("ReqChassisNumber")==null?"":d.get("ReqChassisNumber").toString());
				rawData.setReqRegNumber(d.get("ReqRegNumber")==null?"":d.get("ReqRegNumber").toString());
				rawData.setReqCompanyCode(d.get("ReqCompanyCode")==null?"":d.get("ReqCompanyCode").toString());
				rawData.setResEngineCapacity(d.get("ResEngineCapacity")==null?"":d.get("ResEngineCapacity").toString());
				rawData.setResMsgSignature(d.get("ResMsgSignature")==null?"":d.get("ResMsgSignature").toString());
				rawData.setResOwnerName(d.get("ResOwnerName")==null?"":d.get("ResOwnerName").toString());
				rawData.setResStatusCode(d.get("ResStatusCode")==null?"":d.get("ResStatusCode").toString());
				rawData.setResStatusDesc(d.get("ResStatusDesc")==null?"":d.get("ResStatusDesc").toString());
				rawData.setSavedFrom(d.get("SavedFrom")==null?"":d.get("SavedFrom").toString());
				rawData.setSeatingCapacity(d.get("SeatingCapacity")==null?"0":d.get("SeatingCapacity").toString());
				rawData.setTareWeight(d.get("Tareweight")==null?"":d.get("Tareweight").toString());
				rawData.setVehicleMake(d.get("Vehiclemake")==null?"":d.get("Vehiclemake").toString());
				rawData.setVehicleModel(d.get("Vehcilemodel")==null?"":d.get("Vehcilemodel").toString());
				rawData.setVehicleType(d.get("VehicleType")==null?"":d.get("VehicleType").toString());
				eserviceRepository.saveAndFlush(rawData);	
			}else {
				String tiraErrorDesc=map.getErrorMessage().get(0).getMessage().isEmpty()?"Tira data not found":map.getErrorMessage().get(0).getMessage();
				String existingError =StringUtils.isBlank(rawData.getErrorDesc())?"":rawData.getErrorDesc();
				String error =existingError+"~"+tiraErrorDesc;
				rawData.setErrorDesc(error);
				rawData.setStatus("E");
				eserviceRepository.saveAndFlush(rawData);
			}
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		
		return CompletableFuture.completedFuture(response);
	}
	
	@SuppressWarnings("unchecked")
	@Async
	public CompletableFuture<Object> createQuote(EserviceMotorDetailsRaw p, String auth){
		Object object =new Object();
		try {
			HashMap<String, Object> vehicleRequest =new LinkedHashMap<String,Object>();
			HashMap<String, Object> calcRequest =new LinkedHashMap<String,Object>();
			
			// vehicle request
			vehicleRequest.put("BrokerBranchCode", StringUtils.isBlank(p.getBrokerBranchcode())?"":p.getBrokerBranchcode());
			vehicleRequest.put("AcExecutiveId", StringUtils.isBlank(p.getAcExecutiveid())?"":p.getAcExecutiveid());
			vehicleRequest.put("BrokerCode", StringUtils.isBlank(p.getBrokerCode())?"":p.getBrokerCode());
			vehicleRequest.put("LoginId", StringUtils.isBlank(p.getLoginId())?"":p.getLoginId());
			vehicleRequest.put("SubUserType", StringUtils.isBlank(p.getSubUsertype())?"":p.getSubUsertype());
			vehicleRequest.put("ApplicationId", StringUtils.isBlank(p.getApplicationId())?"":p.getApplicationId());
			vehicleRequest.put("Motorusage", StringUtils.isBlank(p.getMotorUsageId())?"":p.getMotorUsageId());
			vehicleRequest.put("CustomerReferenceNo",StringUtils.isBlank(p.getCustomerReferenceno())?"":p.getCustomerReferenceno());
			vehicleRequest.put("RequestReferenceNo", p.getRequestReferenceNo());
			vehicleRequest.put("Idnumber", StringUtils.isBlank(p.getIdNumber())?"":p.getIdNumber());
			vehicleRequest.put("VehicleId", p.getVehicleId());
			vehicleRequest.put("AcccessoriesSumInsured", p.getAccessoriesSuminsured());
			vehicleRequest.put("AxelDistance", StringUtils.isBlank(p.getAxelDistance())?"":p.getAxelDistance());
			vehicleRequest.put("Chassisnumber", StringUtils.isBlank(p.getReqChassisNo())?"":p.getReqChassisNo());
			vehicleRequest.put("CreatedBy", StringUtils.isBlank(p.getCreatedBy())?"":p.getCreatedBy());
			vehicleRequest.put("Insurancetype", StringUtils.isBlank(p.getInsuranceTypeId())?"":p.getInsuranceTypeId());
			vehicleRequest.put("InsuranceId", p.getCompanyId());
			vehicleRequest.put("InsuranceClass", StringUtils.isBlank(p.getInsuranceClassId())?"":p.getInsuranceClassId());
			vehicleRequest.put("BranchCode", StringUtils.isBlank(p.getBranchCode())?"":p.getBranchCode());
			vehicleRequest.put("AgencyCode", StringUtils.isBlank(p.getAgencyCode())?"":p.getAgencyCode());
			vehicleRequest.put("ProductId", p.getProductId());
			vehicleRequest.put("SumInsured", StringUtils.isBlank(p.getVehicleSuminsured())?"":p.getVehicleSuminsured());
			vehicleRequest.put("Vehcilemodel",StringUtils.isBlank(p.getVehicleModel())?"":p.getVehicleModel());
			vehicleRequest.put("VehicleType", StringUtils.isBlank(p.getBodyTypeId())?"":p.getBodyTypeId());
			vehicleRequest.put("Vehiclemake",StringUtils.isBlank(p.getVehicleMake())?"":p.getVehicleMake());
			vehicleRequest.put("WindScreenSumInsured", StringUtils.isBlank(p.getWindshieldSuminsured())?"":p.getWindshieldSuminsured());
			vehicleRequest.put("PolicyStartDate", StringUtils.isBlank(p.getPolicyStartDate())?"":p.getPolicyStartDate());
			vehicleRequest.put("PolicyEndDate", StringUtils.isBlank(p.getPolicyEndDate())?"":p.getPolicyEndDate());
			vehicleRequest.put("Currency", StringUtils.isBlank(p.getCurrency())?"":p.getCurrency());
			vehicleRequest.put("ExchangeRate", StringUtils.isBlank(p.getExchangeRate())?"":p.getExchangeRate());
			vehicleRequest.put("SavedFrom", StringUtils.isBlank(p.getSavedFrom())?"":p.getSavedFrom());					
			vehicleRequest.put("UserType", StringUtils.isBlank(p.getUserType())?"":p.getUserType()); 
			vehicleRequest.put("SourceType",StringUtils.isBlank(p.getSourceType())?"":p.getSourceType()); 
			vehicleRequest.put("CustomerCode",StringUtils.isBlank(p.getCustomerCode())?"":p.getCustomerCode());
			
			String EndorsementYn =StringUtils.isBlank(p.getEndorsementYn())?"":p.getEndorsementYn();
			String ncdYn =StringUtils.isBlank(p.getNcdYn())?"N":p.getNcdYn();
			String collateralYn =StringUtils.isBlank(p.getCollateral())?"NO":p.getCollateral();
			String promcodeYn =StringUtils.isBlank(p.getHavePromocode())?"N":p.getHavePromocode();
			
			if("Y".equalsIgnoreCase(promcodeYn)) {
				vehicleRequest.put("HavePromoCode",promcodeYn);
				vehicleRequest.put("PromoCode", StringUtils.isBlank(p.getPromocode())?"":p.getPromocode());
			}else {
				vehicleRequest.put("HavePromoCode",promcodeYn);
				vehicleRequest.put("PromoCode", null);
			}
			if("Yes".equalsIgnoreCase(collateralYn)) {
				vehicleRequest.put("CollateralYn", "Y");
				vehicleRequest.put("BorrowerType", StringUtils.isBlank(p.getBorrowerType())?"":p.getBorrowerType());
				vehicleRequest.put("CollateralName", StringUtils.isBlank(p.getFirstLossPayee())?"":p.getFirstLossPayee());
				vehicleRequest.put("FirstLossPayee", StringUtils.isBlank(p.getFirstLossPayee())?"":p.getFirstLossPayee());
			}else {
				vehicleRequest.put("CollateralYn", "N");

			}
			if("Y".equals(ncdYn)) {
				vehicleRequest.put("Gpstrackinginstalled", StringUtils.isBlank(p.getGpsTrackingEnabled())?"":p.getGpsTrackingEnabled());
				vehicleRequest.put("accident" ,"Y");
				vehicleRequest.put("NcdYn", ncdYn);
			}else {
				vehicleRequest.put("NcdYn", ncdYn);
				vehicleRequest.put("Gpstrackinginstalled", "N");

			}
			if("Y".equalsIgnoreCase(EndorsementYn)) {
				vehicleRequest.put("EndorsementDate", StringUtils.isBlank(p.getEndorsementDate())?"":p.getEndorsementDate());
				vehicleRequest.put("EndorsementEffectiveDate", StringUtils.isBlank(p.getEndorsementEffectiveDate())?"":p.getEndorsementEffectiveDate());			
				vehicleRequest.put("EndorsementRemarks", StringUtils.isBlank(p.getEndorsementRemarks())?"":p.getEndorsementRemarks());
				vehicleRequest.put("EndorsementType", StringUtils.isBlank(p.getEndorsementType())?"":p.getEndorsementType());
				vehicleRequest.put("EndorsementTypeDesc", StringUtils.isBlank(p.getEndorsementTypeDesc())?"":p.getEndorsementTypeDesc());
				vehicleRequest.put("EndtCategoryDesc",StringUtils.isBlank(p.getEndtCategoryDesc())?"":p.getEndtCategoryDesc());
				vehicleRequest.put("EndtCount",StringUtils.isBlank(p.getEndtCount())?"":p.getEndtCount());
				vehicleRequest.put("EndtPrevPolicyNo", StringUtils.isBlank(p.getEndtPrevPolicyno())?"":p.getEndtPrevPolicyno());
				vehicleRequest.put("EndtStatus", StringUtils.isBlank(p.getEndtStatus())?"":p.getEndtStatus());
				vehicleRequest.put("IsFinanceEndt", StringUtils.isBlank(p.getIsFinanceEndt())?"":p.getIsFinanceEndt());
				vehicleRequest.put("OrginalPolicyNo", StringUtils.isBlank(p.getOrginalPolicyno())?"":p.getOrginalPolicyno());
				vehicleRequest.put("EndorsementYn", EndorsementYn);
			}else {
				vehicleRequest.put("EndorsementYn", EndorsementYn);

			}

			// default values
			//vehicleRequest.put("NcdYn", "N");
			vehicleRequest.put("TppdIncreaeLimit", ""); 
			vehicleRequest.put("FleetOwnerYn", "N");
			vehicleRequest.put("Status","Y");
			//vehicleRequest.put("accident" ,"N");
			
              
			
			MediaType mediaType =MediaType.parse("application/json");
			
			String vehRequest =print.toJson(vehicleRequest);
			log.info("callCreateQuote || vehRequest " + vehRequest);
		
			Map<String,Object> vehResponse =callApi(vehRequest,auth,mediaType,vehicleApi);
			log.info("callCreateQuote || vehResponse " + print.toJson(vehResponse));
			 //Thread.sleep(10000);  
			
				String responseStatus =vehResponse.get("Message")==null?"":vehResponse.get("Message").toString();
				if("Success".equalsIgnoreCase(responseStatus)) {
					Map<String,Object> data =(Map<String, Object>) vehResponse.get("Result");
					// calc request
					calcRequest.put("InsuranceId", p.getCompanyId());
					calcRequest.put("BranchCode", p.getBranchCode());
					calcRequest.put("AgencyCode", p.getAgencyCode());
					calcRequest.put("SectionId", p.getSectionId());
					calcRequest.put("ProductId", p.getProductId());
					calcRequest.put("MSRefNo", data.get("MSRefNo")==null?"":data.get("MSRefNo").toString());
					calcRequest.put("VehicleId", data.get("VehicleId")==null?"":data.get("VehicleId").toString());
					calcRequest.put("CdRefNo", data.get("CdRefNo")==null?"":data.get("CdRefNo").toString());
					calcRequest.put("VdRefNo", data.get("VdRefNo")==null?"":data.get("VdRefNo").toString());
					calcRequest.put("CreatedBy",StringUtils.isBlank(p.getCreatedBy())?"":p.getCreatedBy());	
					calcRequest.put("RequestReferenceNo", p.getRequestReferenceNo());
					calcRequest.put("EffectiveDate", p.getPolicyStartDate());
					calcRequest.put("PolicyEndDate", p.getPolicyEndDate());
					calcRequest.put("CoverModification", null);
					
					
					String calcReq =print.toJson(calcRequest);
					log.info("callCreateQuote || calcRequest " + calcReq);
					
					Map<String,Object> calcResponse=callApi(calcReq,auth,mediaType,calcApi);
					log.info("callCreateQuote || calcResponse " + print.toJson(calcResponse));
				}
			
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		return CompletableFuture.completedFuture(object);
	}
	
	private Map<String,Object> callApi(String req,String auth,MediaType mediaType,String api) {
		try {

			RequestBody requestBody =RequestBody.create(req,mediaType);
			
			Response response =null;
			
			Request request =new Request.Builder()
					.addHeader("Authorization", "Bearer "+auth)
					.url(api)
					.post(requestBody)
					.build();
			
			response =httpClient.newCall(request).execute();
			String responseString =response.body().string();
			@SuppressWarnings("unchecked")
			Map<String,Object> resMap =mapper.readValue(responseString, Map.class);
			return resMap;
		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		
		return null;
	}

	@Async
	public CompletableFuture<String> createEmployee(EwayEmplyeeDetailRaw req, String auth) {
		String response ="";
		try {
			Map<String,Object> map =new LinkedHashMap<String,Object>();
			map.put("EmployeeName", StringUtils.isBlank(req.getEmployeeName())?"":req.getEmployeeName());
			map.put("Createdby", StringUtils.isBlank(req.getCreatedBy())?"":req.getCreatedBy());
			map.put("InsuranceId", req.getCompanyId()==null?"":req.getCompanyId());
			map.put("OccupationDesc",StringUtils.isBlank(req.getOccupatonDesc())?"":req.getOccupatonDesc());
			map.put("OccupationId", req.getOccupationId()==null?"":req.getOccupationId());
			map.put("ProductId", req.getProductId()==null?"":req.getProductId());
			map.put("QuoteNo", StringUtils.isBlank(req.getQuoteNo())?"":req.getQuoteNo());
			map.put("RequestReferenceNo", StringUtils.isBlank(req.getRequestReferenceNo())?"":req.getRequestReferenceNo());
			map.put("RiskId", req.getRiskId()==null?"":req.getRiskId());
			map.put("Salary", StringUtils.isBlank(req.getSalary())?"":req.getSalary());
			map.put("NationalityId", StringUtils.isBlank(req.getNationalityId())?"":req.getNationalityId());
			map.put("DateOfJoiningYear", StringUtils.isBlank(req.getDateOfJoining())?"":req.getDateOfJoining());
			map.put("DateOfJoiningMonth", StringUtils.isBlank(req.getDateOfJoiningMonth())?"":req.getDateOfJoiningMonth());
			map.put("DateOfBirth", StringUtils.isBlank(req.getDateOfBirth())?"":req.getDateOfBirth());
			map.put("EmployeeId", req.getSno());
			
			String request =print.toJson(map);
			log.info("createEmployee || request "+"["+request+"]");
			MediaType mediaType =MediaType.parse("application/json");
			Map<String,Object> apiRes =callApi("["+request+"]", auth, mediaType, employeeSaveApi);
			log.info("createEmployee || response "+apiRes);

		}catch (Exception e) {
			log.error(e);
			e.printStackTrace();
		}
		return CompletableFuture.completedFuture(response);
	}

}
