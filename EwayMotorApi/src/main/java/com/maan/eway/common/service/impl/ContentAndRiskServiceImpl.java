package com.maan.eway.common.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maan.eway.bean.ContentAndRisk;
import com.maan.eway.bean.EserviceBuildingDetails;
import com.maan.eway.bean.ListItemValue;
import com.maan.eway.bean.PersonalAccident;
import com.maan.eway.bean.SectionMaster;
import com.maan.eway.common.req.ContentAndRiskSaveReq;
import com.maan.eway.common.req.ContentRiskDetailsListReq;
import com.maan.eway.common.req.ContentRiskGetAllReq;
import com.maan.eway.common.req.ContentRiskGetReq;
import com.maan.eway.common.req.OccupationReqClass;
import com.maan.eway.common.req.RiskDuplicateCheckReq;
import com.maan.eway.common.res.ContentRiskDetailsRes;
import com.maan.eway.common.res.ContentRiskGetRes;
import com.maan.eway.common.res.ContentRiskGetallRes;
import com.maan.eway.common.res.PersonalDetailsGetallRes;
import com.maan.eway.common.service.ContentAndRiskService;
import com.maan.eway.error.Error;
import com.maan.eway.repository.ContentAndRiskRepository;
import com.maan.eway.repository.EServiceBuildingDetailsRepository;
import com.maan.eway.repository.ListItemValueRepository;
import com.maan.eway.repository.SectionMasterRepository;
import com.maan.eway.res.SuccessRes;

@Service
@Transactional
public class ContentAndRiskServiceImpl implements ContentAndRiskService {

	@Autowired
	private ContentAndRiskRepository repo;

	@Autowired
	private ListItemValueRepository listrepo;

	@Autowired
	private SectionMasterRepository sectionrepo;
	
	@Autowired
	private EServiceBuildingDetailsRepository eserBuildingRepo ;

	
	
	private Logger log = LogManager.getLogger(ContentAndRiskServiceImpl.class);

	@Override
	public List<Error>validatecontentrisk(ContentAndRiskSaveReq req) {
		List<Error> error = new ArrayList<Error>();

		try {
			Long row = 0L ;
			BigDecimal sumInsured = BigDecimal.ZERO ;
			String quoteNo = "" ;
			EserviceBuildingDetails buidingData = new EserviceBuildingDetails(); 

			if (StringUtils.isBlank(req.getSectionId())) {
				error.add(new Error("01", "SectionId", "Please Select Section Id"));
			}

			
			if (StringUtils.isBlank(req.getQuoteNo())) {
				error.add(new Error("03", "QuoteNo", "Please Select QuoteNo"));
			}
			else {
				quoteNo = req.getQuoteNo() ;
				buidingData = eserBuildingRepo.findByQuoteNo(quoteNo);
			}
			if (StringUtils.isBlank(req.getType())) {
				error.add(new Error("04", "Type", "Please Select Type"));
			}
			
			List<RiskDuplicateCheckReq> contAndRisks = new ArrayList<RiskDuplicateCheckReq>(); 
			ListItemValue type = listrepo.findByItemTypeAndItemCode("CONTENT_RISK",req.getType());
			for(ContentRiskDetailsListReq req1 : req.getContentriskdetails()) {
				row = row + 1 ;
				if (StringUtils.isBlank(req1.getRiskId())) {
					error.add(new Error("02", "RiskId", "Please Select RiskId In Row No:" + row ));
				}
				if (StringUtils.isBlank(req1.getItemId())) {
					error.add(new Error("05", "ItemId", "Please Select ItemType In Row No:" + row ));
				}
				
				if (StringUtils.isNotBlank(req1.getContentRiskDesc())) {
					if (req1.getContentRiskDesc().length() > 500 ) {
						
						error.add(new Error("05", "ItemId", "Description Must be Under 500 Charecter Only Allowed In Row No:" + row ));
					}
				}
				
				if (StringUtils.isNotBlank(req1.getSerialNoDesc())) {
					if (req1.getSerialNoDesc().length() > 500 ) {
						
						error.add(new Error("05", "ItemId", "Serial No Must be Under 500 Charecter Only Allowed In Row No:" + row ));
					}
//					else if ( ! req1.getSerialNoDesc().matches("[0-9-a-zA-Z]")  ) {
//						
//						error.add(new Error("05", "ItemId", "Serial No AlphaNumeric Only Allowed In Row No:" + row ));
//					}
				}
//				if (StringUtils.isBlank(req1.getItemValue())) {
//					error.add(new Error("06", "ItemValue", "Please Enter ItemValue"));
//				}
//				else if (!req1.getItemValue().matches("[0-9.]+")) {
//					error.add(new Error("06", "ItemValue", "Please Enter Valid Number In ItemValue"));
//				}
				
				// Content DUplicate CHecking
				if (StringUtils.isNotBlank(req1.getRiskId()) && StringUtils.isNotBlank(req1.getItemId())  ) {
					ListItemValue itemvalue = listrepo.findByItemTypeAndItemCode(type.getItemValue() ,req1.getItemId());
					if(itemvalue.getItemValue().equalsIgnoreCase("All") ) {
						List<RiskDuplicateCheckReq> filterContAndRisks = contAndRisks.stream().filter( 
								o ->  o.getRiskId().equalsIgnoreCase(req1.getRiskId()) ).collect(Collectors.toList());
						if( filterContAndRisks.size() > 0 ) { 
							error.add(new Error("07", "Duplicate",type.getItemValue() + " - " + itemvalue.getItemValue()  + " Should not Allow Other Item Type  for same Location" ));
							
						}else {
							contAndRisks.add(new RiskDuplicateCheckReq(req1.getRiskId(),req1.getItemId()));
							
						}
						
					} else {
						
						List<RiskDuplicateCheckReq> filterAllType = contAndRisks.stream().filter( 
								o ->  o.getRiskId().equalsIgnoreCase(req1.getRiskId())  && o.getValue().equalsIgnoreCase("9")  ).collect(Collectors.toList());
						if( filterAllType.size() > 0 ) { 
							error.add(new Error("07", "Duplicate",type.getItemValue() + " - All"  + " Should not Allow Other Item Type  for same Location" ));
							
						}else {
							List<RiskDuplicateCheckReq> filterContAndRisks = contAndRisks.stream().filter( 
									o ->  o.getRiskId().equalsIgnoreCase(req1.getRiskId())  && o.getValue().equalsIgnoreCase(req1.getItemId())  ).collect(Collectors.toList());
							if( filterContAndRisks.size() > 0 ) { 
								error.add(new Error("07", "Duplicate", type.getItemValue() + " - " + itemvalue.getItemValue()  + "  Duplicate for same Location In Row No:" + row ));
								
							} else {
								contAndRisks.add(new RiskDuplicateCheckReq(req1.getRiskId(),req1.getItemId()));
								
							}
							
						}
						
					}
					
				}
				
				if (StringUtils.isBlank(req1.getMakeAndModel())) {
					error.add(new Error("07", "MakeAndModel", "Please Enter MakeAndModel In Row No:" + row ));
				}
				if (StringUtils.isBlank(req1.getSerialNo())) {
					error.add(new Error("08", "SerialNo", "Please Enter SerialNo In Row No:" + row ));
				}
				if (StringUtils.isBlank(req1.getSumInsured())) {
					error.add(new Error("09", "SumInsured", "Please Enter SumInsured In Row No:" + row ));
				}
				else if (!req1.getSumInsured().matches("[0-9.]+") || Double.valueOf(req1.getSumInsured()) <=0) {
					error.add(new Error("09", "SumInsured", "Please Enter Valid Number In SumInsured In Row No:" + row ));
				}
				else if (req1.getSumInsured().equalsIgnoreCase("0") ) {
					error.add(new Error("09", "SumInsured", "Please Enter SumInsured above 0 In Row No:" + row ));
				}
				else {
					sumInsured = sumInsured.add(new BigDecimal(req1.getSumInsured()));
				}
				if ((StringUtils.isNotBlank(req.getType()))&& req.getType().equalsIgnoreCase("E")) {
					if (StringUtils.isBlank(req1.getPurchaseYear())) {
						error.add(new Error("10", "PurchaseYear", "Please Enter PurchaseYear In Row No:" + row ));
					}
					if (StringUtils.isBlank(req1.getPurchaseMonth())) {
						error.add(new Error("11", "PurchaseMonth", "Please Enter PurchaseMonth In Row No:" + row ));
					}
				}
				
				
				
			}
			

			if((StringUtils.isNotBlank(req.getType()))&&req.getType().equalsIgnoreCase("C")) {
			if(StringUtils.isNotBlank(quoteNo)  ) {
				if(buidingData.getContentSuminsured()!=null && sumInsured.compareTo(buidingData.getContentSuminsured()) > 0 ) {
					error.add(new Error("03", "SumINsured", " Total SumInsured Greater Than Actual SumInsured In Row No:" + row  ));
				}
			}
			}
			
			if((StringUtils.isNotBlank(req.getType()))&&req.getType().equalsIgnoreCase("A")) {
				if(StringUtils.isNotBlank(quoteNo)  ) {
					if(buidingData.getAllriskSuminsured()!=null && sumInsured.compareTo(buidingData.getAllriskSuminsured()) > 0 ) {
						error.add(new Error("03", "SumINsured", " Total SumInsured Greater Than Actual AllriskSuminsured In Row No:" + row  ));
					}
				}
				}

			if((StringUtils.isNotBlank(req.getType()))&&req.getType().equalsIgnoreCase("E")) {
				if(StringUtils.isNotBlank(quoteNo)  ) {
					if(buidingData.getElecEquipSuminsured()!=null && sumInsured.compareTo(buidingData.getElecEquipSuminsured()) > 0 ) {
						error.add(new Error("03", "SumINsured", " Total SumInsured Greater Than Actual ElecEquipSuminsured In Row No:" + row  ));
					}
				}
				}
			/*
		
			// Content Type Validation
			List<String> risk = new ArrayList<String>();
			List<String> risk1 = new ArrayList<String>();
			
			List<String> item = new ArrayList<String>();
			List<String> item1 = new ArrayList<String>();

			Integer row=0;
			for (ContentRiskDetailsListReq req2 : req.getContentriskdetails()) {

				risk1 = risk.stream().filter( 
							o ->  o
							.equalsIgnoreCase(req2.getRiskId()))
							.collect(Collectors.toList());			
				
				item1 = item.stream().filter( 
						o ->  o
						.equalsIgnoreCase(req2.getItemId()))
						.collect(Collectors.toList());			
				row++;
				
				if(risk1.size()>0&&item1.size()>0) {
					error.add(new Error("36", "Item Id", "Duplicate Item Id Not Allowed in "+row));

				}
				else {

				
				risk.add(req2.getRiskId());
				item.add(req2.getItemId());
				}
			}
		
*/
		
			
			
		}
		 catch (Exception e) {

				log.error(e);
				e.printStackTrace();
			}
			return error;
		}

	
	
	@Override
	public SuccessRes savecontentrisk(ContentAndRiskSaveReq req) {
		SuccessRes res = new SuccessRes();
		DozerBeanMapper dozermapper = new DozerBeanMapper();
		
		
		try {
			List<ContentAndRisk> count = repo.findByQuoteNoAndType(req.getQuoteNo(),req.getType() );
			
			repo.deleteAll(count);
	
			ContentAndRisk saveData = new ContentAndRisk();
			Date entryDate = new Date();

			
			List<SectionMaster> section = sectionrepo.findBySectionIdOrderByAmendIdDesc(Integer.valueOf(req.getSectionId()));
			ListItemValue type = listrepo.findByItemTypeAndItemCode("CONTENT_RISK",req.getType());
		
			saveData=dozermapper.map(req, ContentAndRisk.class);
			saveData.setEntryDate(entryDate);
			saveData.setCreatedBy(req.getCreatedBy());
			saveData.setStatus("Y");
			saveData.setQuoteNo(req.getQuoteNo());	
			saveData.setSectionDesc(section.get(0).getSectionName());
			saveData.setTypeDesc(type.getItemValue());
			res.setSuccessId(req.getQuoteNo());
			res.setResponse("Saved Successful");
			
			List<ContentRiskDetailsListReq> reqList =  req.getContentriskdetails()  ;
			
			Map<String,	List<ContentRiskDetailsListReq>> groupByRiskId = reqList.stream().collect(Collectors.groupingBy(ContentRiskDetailsListReq :: getRiskId))  ;
			
			for (String riskId : groupByRiskId.keySet() ) {
				List<ContentRiskDetailsListReq> filterData =  groupByRiskId.get(riskId) ;
				BigDecimal sno = BigDecimal.ZERO ;
				for(ContentRiskDetailsListReq reqdata :filterData) {
					sno = sno.add(BigDecimal.ONE);
					ListItemValue itemvalue = listrepo.findByItemTypeAndItemCode(type.getItemValue() ,reqdata.getItemId());
					saveData.setItemId(Integer.valueOf(reqdata.getItemId()));
					saveData.setItemValue(new BigDecimal(reqdata.getItemValue()));
					saveData.setItemDesc(itemvalue.getItemValue());
					saveData.setSumInsured(new BigDecimal(reqdata.getSumInsured()));
					saveData.setSerialNo(sno);
					saveData.setMakeAndModel(reqdata.getMakeAndModel());
					saveData.setRiskId(Integer.valueOf(reqdata.getRiskId()));
					saveData.setPurchaseYear((StringUtils.isBlank(reqdata.getPurchaseYear()))?"": reqdata.getPurchaseYear());
					saveData.setPurchaseMonth((StringUtils.isBlank(reqdata.getPurchaseMonth()))?"": reqdata.getPurchaseMonth());
					saveData.setContentRiskDesc(StringUtils.isBlank(reqdata.getContentRiskDesc())?"": reqdata.getContentRiskDesc());
					saveData.setSerialNoDesc(StringUtils.isBlank(reqdata.getSerialNoDesc())?"": reqdata.getSerialNoDesc());
					repo.saveAndFlush(saveData);

				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Log Details" + e.getMessage());
			return null;
		}

		return res;
	}


	@Override
	public ContentRiskGetRes getcontentrisk(ContentRiskGetReq req) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		ContentRiskGetRes res = new ContentRiskGetRes();
		DozerBeanMapper dozermapper = new DozerBeanMapper();
		try {
			
			ContentAndRisk data = repo.findByQuoteNoAndRiskIdAndSectionIdAndItemId(req.getQuoteNo(),Integer.valueOf(req.getRiskId()),req.getSectionId(),Integer.valueOf(req.getItemId()));
			if(data!=null) {
			res = dozermapper.map(data, ContentRiskGetRes.class);
			res.setRiskId(data.getRiskId().toString());
			res.setItemId(data.getItemId().toString());
			res.setItemValue(data.getItemValue().toString());
			res.setSumInsured(data.getSumInsured().toString());
			res.setSerialNo(data.getSerialNo().toString());
			res.setEntryDate(data.getEntryDate());
			res.setUpdatedDate(data.getUpdatedDate());
			res.setPurchaseYear(data.getPurchaseYear()==null?"":data.getPurchaseYear());
			res.setPurchaseMonth(data.getPurchaseMonth()==null?"":data.getPurchaseMonth());			
			}
		else {
			return res;
		}
		} 
		
		catch (Exception e) {
		e.printStackTrace();
		log.info("Log Details" + e.getMessage());
		return null;
	}

	return res;
	}

	@Override
	public ContentRiskGetallRes getallcontentrisk(ContentRiskGetAllReq req) {
		ContentRiskGetallRes res = new ContentRiskGetallRes();
		DozerBeanMapper dozermapper  = new DozerBeanMapper();
		try {
		
			List<ContentAndRisk> datas = repo.findByQuoteNoAndSectionId(req.getQuoteNo(),req.getSectionId());
			if(datas!=null  && datas.size()>0 ) {

			res = dozermapper.map(datas.get(0),ContentRiskGetallRes.class);			
			res.setQuoteNo(datas.get(0).getQuoteNo());
			res.setRequestReferenceNo(datas.get(0).getRequestReferenceNo());
			res.setSectionId(datas.get(0).getSectionId());				
			res.setSectionDesc(datas.get(0).getSectionDesc());
			res.setType(datas.get(0).getType());
			res.setTypeDesc(datas.get(0).getTypeDesc());
			
			List<ContentRiskDetailsRes> resList1 = new ArrayList<ContentRiskDetailsRes>();;
		
			for(ContentAndRisk data : datas) {
				ContentRiskDetailsRes res1 = new ContentRiskDetailsRes();
				res1=dozermapper.map(data, ContentRiskDetailsRes.class);
				res1.setSumInsured(data.getSumInsured().toString());
				res1.setItemId(data.getItemId().toString());
				res1.setItemValue(data.getItemValue().toString());
				res1.setRiskId(data.getRiskId().toString()  );
				res1.setPurchaseYear(data.getPurchaseYear()==null?"":data.getPurchaseYear());
				res1.setPurchaseMonth(data.getPurchaseMonth()==null?"":data.getPurchaseMonth());			
				res1.setContentRiskDesc(data.getContentRiskDesc()==null?"":data.getContentRiskDesc());
				res1.setSerialNoDesc(data.getSerialNoDesc()==null?"":data.getSerialNoDesc());
				resList1.add(res1);
				
			}
			resList1.sort( Comparator.comparing(ContentRiskDetailsRes :: getRiskId ));
			res.setContentriskdetails(resList1);
		}
			else {
				return res;
			
		}
		}
		catch (Exception e) {
		e.printStackTrace();
		log.info("Log Details" + e.getMessage());
		return null;
	}

	return res;
	}		
		
	
}
