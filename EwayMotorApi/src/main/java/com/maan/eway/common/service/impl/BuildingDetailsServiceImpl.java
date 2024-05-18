package com.maan.eway.common.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maan.eway.bean.BuildingDetails;
import com.maan.eway.bean.ContentAndRisk;
import com.maan.eway.bean.EserviceBuildingDetails;
import com.maan.eway.bean.EserviceSectionDetails;
import com.maan.eway.bean.ListItemValue;
import com.maan.eway.bean.SectionMaster;
import com.maan.eway.common.req.BuildingDetailsGetAllReq;
import com.maan.eway.common.req.BuildingDetailsGetReq;
import com.maan.eway.common.req.BuildingDetailsSaveReq;
import com.maan.eway.common.res.BuildingDetailsGetRes;
import com.maan.eway.common.service.BuildingDetailsService;
import com.maan.eway.error.Error;
import com.maan.eway.repository.BuildingDetailsRepository;
import com.maan.eway.repository.ContentAndRiskRepository;
import com.maan.eway.repository.EServiceBuildingDetailsRepository;
import com.maan.eway.repository.EServiceSectionDetailsRepository;
import com.maan.eway.repository.ListItemValueRepository;
import com.maan.eway.repository.PersonalAccidentRepository;
import com.maan.eway.repository.SectionMasterRepository;
import com.maan.eway.res.SuccessRes;

@Service
@Transactional
public class BuildingDetailsServiceImpl implements BuildingDetailsService {

	@Autowired
	private BuildingDetailsRepository repo;

	@Autowired
	private ListItemValueRepository listrepo;

	@Autowired
	private SectionMasterRepository sectionrepo;
	
	@Autowired
	private EServiceBuildingDetailsRepository eserBuildingRepo ;
	
	@Autowired
	private EServiceSectionDetailsRepository eserSecRepo ;
	
	@Autowired
	private ContentAndRiskRepository contentRepo ;
	
	@Autowired
	private PersonalAccidentRepository paccRepo ;

	private Logger log = LogManager.getLogger(EserviceBuildingDetailsServiceImpl.class);

	@Override
	public List<Error> validatebuildingDetails(List<BuildingDetailsSaveReq> reqList) {		
		List<Error> error = new ArrayList<Error>();

		try {
			
			Long row = 0L ;
			BigDecimal sumInsured = BigDecimal.ZERO ;
			String quoteNo = "" ;
			List<String> locations = new ArrayList<String>();
			EserviceBuildingDetails buidingData = new EserviceBuildingDetails();
			List<EserviceSectionDetails> domesticSection =  new ArrayList<EserviceSectionDetails>();
			List<EserviceSectionDetails> parSection =  new ArrayList<EserviceSectionDetails>();
			
			if(reqList!=null && reqList.size()> 0 && StringUtils.isNotBlank(reqList.get(0).getQuoteNo() )  ) {
				buidingData = eserBuildingRepo.findByQuoteNo(reqList.get(0).getQuoteNo() );
				List<EserviceSectionDetails> sectionList =  eserSecRepo.findByRequestReferenceNoOrderByRiskIdAsc(buidingData.getRequestReferenceNo() );
				domesticSection = sectionList.stream().filter( o -> o.getSectionId().equalsIgnoreCase("1") ).collect(Collectors.toList()) ; 
				parSection = sectionList.stream().filter( o -> o.getSectionId().equalsIgnoreCase("40") ).collect(Collectors.toList()) ; 
				
			}
			
			
			for(BuildingDetailsSaveReq req : reqList) {
				row = row +1;
				if (StringUtils.isBlank(req.getQuoteNo())) {
					error.add(new Error("01", "QuoteNo", "Please Select QuoteNo in Row : " + row));
				}else {
					quoteNo = req.getQuoteNo() ;
					buidingData = eserBuildingRepo.findByQuoteNo(quoteNo);
				}
				
				if (StringUtils.isBlank(req.getSectionId())) {
					error.add(new Error("01", "SectionId", "Please Select Section Id In Row No : " + row ));
				}
				
				
				if(domesticSection.size() > 0 ||parSection.size() > 0    ) {
					if (StringUtils.isBlank(req.getBuildingSuminsured())) {
						error.add(new Error("08", "BuildingSuminsured", "Please Enter BuildingSuminsured In Row No : " + row));
					} else if (!req.getBuildingSuminsured().matches("[0-9.]+")  || Double.valueOf(req.getBuildingSuminsured()) <=0 ) {
						error.add(new Error("09", "BuildingSuminsured", "Please Enter Valid Number In BuildingSuminsured In Row No : " + row));
					} else {
						sumInsured = sumInsured.add(new BigDecimal(req.getBuildingSuminsured()));
					}

				}
				
				if (StringUtils.isBlank(req.getBuildingAddress())) {
					error.add(new Error("03", "BuildingAddress", "Please Enter BuildingAddress In Row No : " + row));
				} else if (StringUtils.isNotBlank(req.getBuildingAddress())  &&req.getBuildingAddress().length()>1000 ) {
					error.add(new Error("03", "BuildingAddress", "Please Enter BuildingAddress within 1000 Characters : " + row));
				}
				if (StringUtils.isBlank(req.getLocationName()) ) {
					error.add(new Error("03", "LocationName", "Please Enter LocationName In Row No : " + row));
				}
				else if ((StringUtils.isNotBlank(req.getLocationName()))&&!req.getLocationName().matches("[A-Z a-z]+")) {
					error.add(new Error("03", "LocationName", "Please Enter Valid Name In Location Name In Row No:" + row ));
				}

				else {
					List<String> filterLocations =  locations.stream().filter( o -> o.equals(req.getLocationName()) ).collect(Collectors.toList());
					if(filterLocations.size()> 0) {
						error.add(new Error("03", "LocationName", "LocationName Duplicate In Row No : " + row));
					} else {
						locations.add(req.getLocationName());
					}
				}
			}
			
			if(StringUtils.isNotBlank(quoteNo)  ) {
				if(buidingData.getBuildingSuminsured()!=null && sumInsured.compareTo(buidingData.getBuildingSuminsured()) > 0 && ( domesticSection.size() > 0 ||parSection.size() > 0    )) {
					error.add(new Error("03", "BuildingSumINsured", "Locations Total SumInsured Greater Than Actual SumInsured" ));
				}
				
			}
		
	} catch (Exception e) {

		log.error(e);
		e.printStackTrace();
	}
	return error;
}

	@Override
	public SuccessRes savebuildingDetails(List<BuildingDetailsSaveReq> reqList) {
		// TODO Auto-generated method stub
		SuccessRes res = new SuccessRes();
		DozerBeanMapper dozermapper = new DozerBeanMapper();
		SimpleDateFormat yf = new SimpleDateFormat("yyyy");

		try {
			String quoteNo = reqList.get(0).getQuoteNo() ;
					
			BuildingDetails saveData = new BuildingDetails();
			EserviceBuildingDetails eserBuildingData = eserBuildingRepo.findByQuoteNo(quoteNo);
			Date entryDate = new Date();
			Integer riskid=0;
			// Drop Downs
			List<BuildingDetails> data = repo.findByQuoteNo(reqList.get(0).getQuoteNo());
			if (data != null) {
				repo.deleteAll(data);
			}
			ListItemValue inbuildconstruct  = new ListItemValue (); 
				for(BuildingDetailsSaveReq req : reqList) {
					if(eserBuildingData!=null) {
					 inbuildconstruct = listrepo.findByItemTypeAndItemCode("CONSTRUCT_TYPE", eserBuildingData.getInbuildConstructType() );
						saveData.setBuildingFloors(eserBuildingData.getBuildingFloors());
						saveData.setBuildingUsageId(eserBuildingData.getBuildingUsageId());
						saveData.setBuildingUsageDesc(eserBuildingData.getBuildingUsageDesc());
						saveData.setBuildingAge(eserBuildingData.getBuildingAge());
						saveData.setInbuildConstructType(eserBuildingData.getInbuildConstructType() );
					
					}
					List<SectionMaster> sectionName = sectionrepo.findBySectionIdOrderByAmendIdDesc(Integer.valueOf(req.getSectionId())); 	
					riskid = StringUtils.isBlank(req.getRiskId()) ? riskid + 1 : Integer.valueOf(req.getRiskId())  ;
				saveData=dozermapper.map(req, BuildingDetails.class);
				saveData.setUpdatedDate(new Date());
				saveData.setUpdatedBy(req.getCreatedBy());
				saveData.setLocationName(req.getLocationName());
				saveData.setEntryDate(entryDate);
				saveData.setCreatedBy(req.getCreatedBy());
				saveData.setStatus("Y");
				saveData.setRequestReferenceNo(req.getRequestReferenceNo());
				//saveData.setBuildingPurpose(buidingpurpose.getItemValue());
				saveData.setBuildingSuminsured(req.getBuildingSuminsured()==null?null:new BigDecimal(req.getBuildingSuminsured()));
				saveData.setBuildingAreaSqm(req.getBuildingAreaSqm()==null?null:Double.valueOf(req.getBuildingAreaSqm()));
				saveData.setInbuildConstructTypeDesc(inbuildconstruct!=null? inbuildconstruct.getItemValue():"" );
				saveData.setWithoutInhabitantDays(req.getWithoutInhabitantDays()==null?null:Integer.valueOf(req.getWithoutInhabitantDays()));
				saveData.setSectionDesc(sectionName.get(0).getSectionName());
				// Building Age Calculation
				saveData.setRiskId(riskid);
				saveData.setQuoteNo(req.getQuoteNo());
				saveData.setSectionId(req.getSectionId());
				riskid++;
				repo.saveAndFlush(saveData);
				res.setSuccessId(req.getRequestReferenceNo());
				res.setResponse("Updted Successful");
				
				}
				
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Log Details" + e.getMessage());
			return null;
		}

		return res;
	}

	@Override
	public BuildingDetailsGetRes getbuildingDetails(BuildingDetailsGetReq req) {
		// TODO Auto-generated method stub
		BuildingDetailsGetRes res = new BuildingDetailsGetRes();
		DozerBeanMapper dozermapper = new DozerBeanMapper();
		try {
			BuildingDetails data = repo.findByQuoteNoAndRiskId(req.getQuoteNo(),Integer.valueOf(req.getRiskId()));
				if(data!=null) {
					res = dozermapper.map(data, BuildingDetailsGetRes.class);
					res.setBuildingAreaSqm(data.getBuildingAreaSqm()==null?"":data.getBuildingAreaSqm().toString());
					res.setBuildingSuminsured(data.getBuildingSuminsured()==null?"":data.getBuildingSuminsured().toString());
					res.setBuildingAge(data.getBuildingAge()==null?"":data.getBuildingAge().toString());			
					res.setBuildingFloors(data.getBuildingFloors()==null?"":data.getBuildingFloors().toString());		
					res.setBuildingBuildYear(data.getBuildingBuildYear()==null?"":data.getBuildingBuildYear().toString());		
					res.setWithoutInhabitantDays(data.getWithoutInhabitantDays()==null?"":data.getWithoutInhabitantDays().toString());
					res.setRiskId(data.getRiskId()==null?"":data.getRiskId().toString());
					}
				else {
				  return res;
				}
				
				
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info("Log Details"+e.getMessage());
			return null;
		}
		return res;
	}
	
	
	
	@Override
	public List<BuildingDetailsGetRes> getallbuildingDetails(BuildingDetailsGetAllReq req) {
		// TODO Auto-generated method stub
		List<BuildingDetailsGetRes> resList = new ArrayList<BuildingDetailsGetRes>();
		DozerBeanMapper dozermapper = new DozerBeanMapper();
		try {
			List<BuildingDetails> datas = repo.findByQuoteNo(req.getQuoteNo());

			if(datas!=null) {
			for(BuildingDetails data : datas) {
					BuildingDetailsGetRes res = new BuildingDetailsGetRes();
					res = dozermapper.map(data, BuildingDetailsGetRes.class);
					res.setBuildingAreaSqm(data.getBuildingAreaSqm()==null?"":data.getBuildingAreaSqm().toString());
					res.setBuildingSuminsured(data.getBuildingSuminsured()==null?"":data.getBuildingSuminsured().toString());
					res.setBuildingAge(data.getBuildingAge()==null?"":data.getBuildingAge().toString());			
					res.setBuildingFloors(data.getBuildingFloors()==null?"":data.getBuildingFloors().toString());		
					res.setBuildingBuildYear(data.getBuildingBuildYear()==null?"":data.getBuildingBuildYear().toString());		
					res.setWithoutInhabitantDays(data.getWithoutInhabitantDays()==null?"":data.getWithoutInhabitantDays().toString());
					res.setRiskId(data.getRiskId()==null?"":data.getRiskId().toString());
					resList.add(res);
			}
			}
			else {
				return resList;
			}
				
		}
		catch(Exception e) {
			e.printStackTrace();
			log.info("Log Details"+e.getMessage());
			return null;
		}
		return resList;
	}

	@Override
	public SuccessRes deleteBuildingDetails(BuildingDetailsGetReq req) {
			SuccessRes res = new SuccessRes();
			try {
				// Building
				Long buildingCount = repo.countByQuoteNoAndRiskId(req.getQuoteNo() ,Integer.valueOf(req.getRiskId()));
				if(buildingCount > 0 ) {
					repo.deleteByQuoteNoAndRiskId(req.getQuoteNo() ,Integer.valueOf(req.getRiskId()));
				}
				
				// Content And All Risk
				Long contentCount = contentRepo.countByQuoteNoAndRiskId(req.getQuoteNo() ,Integer.valueOf(req.getRiskId()));
				if(contentCount > 0 ) {
					contentRepo.deleteByQuoteNoAndRiskId(req.getQuoteNo() ,Integer.valueOf(req.getRiskId()));
				}
				
				// Personal Accident
				Long paccCount = paccRepo.countByQuoteNoAndRiskId(req.getQuoteNo() ,Integer.valueOf(req.getRiskId()));
				if(paccCount > 0 ) {
					paccRepo.deleteByQuoteNoAndRiskId(req.getQuoteNo() ,Integer.valueOf(req.getRiskId()));
				}
				
				res.setResponse("Deleted Successfully") ;
				res.setSuccessId(req.getQuoteNo()) ;;
					
			}
			catch(Exception e) {
				e.printStackTrace();
				log.info("Log Details"+e.getMessage());
				return null;
			}
			return res;
		}
	

}
