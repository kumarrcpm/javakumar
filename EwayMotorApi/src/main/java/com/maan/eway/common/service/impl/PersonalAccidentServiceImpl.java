package com.maan.eway.common.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maan.eway.bean.EserviceBuildingDetails;
import com.maan.eway.bean.EserviceCommonDetails;
import com.maan.eway.bean.ListItemValue;
import com.maan.eway.bean.OccupationMaster;
import com.maan.eway.bean.PersonalAccident;
import com.maan.eway.bean.SectionMaster;
import com.maan.eway.common.req.PersonalAccidentDetailsListReq;
import com.maan.eway.common.req.PersonalAccidentGetAllReq;
import com.maan.eway.common.req.PersonalAccidentGetReq;
import com.maan.eway.common.req.PersonalAccidentSaveReq;
import com.maan.eway.common.req.RiskDuplicateCheckReq;
import com.maan.eway.common.res.PersonalAccidentGetAllRes;
import com.maan.eway.common.res.PersonalAccidentGetRes;
import com.maan.eway.common.res.PersonalDetailsGetallRes;
import com.maan.eway.common.service.PersonalAccidentService;
import com.maan.eway.error.Error;
import com.maan.eway.repository.EServiceBuildingDetailsRepository;
import com.maan.eway.repository.EserviceCommonDetailsRepository;
import com.maan.eway.repository.ListItemValueRepository;
import com.maan.eway.repository.OccupationMasterRepository;
import com.maan.eway.repository.PersonalAccidentRepository;
import com.maan.eway.repository.SectionMasterRepository;
import com.maan.eway.res.SuccessRes;

@Service
@Transactional
public class PersonalAccidentServiceImpl implements PersonalAccidentService {

	@Autowired
	private PersonalAccidentRepository repo;

	@Autowired
	private ListItemValueRepository listrepo;

	@Autowired
	private SectionMasterRepository sectionrepo;

	@Autowired
	private OccupationMasterRepository occupationrepo;

	@Autowired
	private EServiceBuildingDetailsRepository eserBuildingRepo ;

	@Autowired
	private EserviceCommonDetailsRepository commonRepo;
	

	
	private Logger log = LogManager.getLogger(PersonalAccidentServiceImpl.class);

	@Override
	public List<Error> validatepersonalaccident(PersonalAccidentSaveReq req) {
		List<Error> error = new ArrayList<Error>();

		try {
			Long row = 0L ;
			BigDecimal sumInsured = BigDecimal.ZERO ;
			String quoteNo = "" ;
			EserviceBuildingDetails buidingData = new EserviceBuildingDetails(); 
			EserviceCommonDetails accidentData = new EserviceCommonDetails(); 

			if (StringUtils.isBlank(req.getSectionId())) {
				error.add(new Error("01", "SectionId", "Please Select Section Id"));
			}
			if (StringUtils.isBlank(req.getQuoteNo())) {
				error.add(new Error("03", "QuoteNo", "Please Select QuoteNo"));
			}
			else {
				quoteNo = req.getQuoteNo() ;
				buidingData = eserBuildingRepo.findByQuoteNo(quoteNo);
				accidentData = commonRepo.findByQuoteNo(quoteNo);
			}
			
			BigDecimal zero = BigDecimal.ZERO;
		/*	if(StringUtils.isNotBlank(req.getType())&&req.getType().equalsIgnoreCase("PA")) {
				for(PersonalAccidentDetailsListReq req1:  req.getPersonaldetails()) {				
				if (StringUtils.isBlank(req1.getPaDeathSuminsured())) {
					error.add(new Error("03", "PaDeathSuminsured", "Please Enter PaDeathSuminsured"));
				} else if (!req1.getPaDeathSuminsured().matches("[0-9.]+")) {
					error.add(new Error("03", "PaDeathSuminsured", "Please Enter Valid Number In PaDeathSuminsured"));
				}
				else if (req1.getPaDeathSuminsured().equalsIgnoreCase("0")) {
					error.add(new Error("03", "PaDeathSuminsured", "Please Enter PaDeathSuminsured above 0"));
				}
				if (StringUtils.isBlank(req1.getPaMedicalSuminsured())) {
					error.add(new Error("04", "PaMedicalSuminsured", "Please Enter PaMedicalSuminsured"));
				} else if (!req1.getPaMedicalSuminsured().matches("[0-9.]+")) {
					error.add(new Error("04", "PaMedicalSuminsured", "Please Enter Valid Number In PaMedicalSuminsured"));
				}
				else if (req1.getPaMedicalSuminsured().equalsIgnoreCase("0") ) {
					error.add(new Error("04", "PaMedicalSuminsured", "Please Enter PaMedicalSuminsured above 0"));
				}
	
				if (StringUtils.isBlank(req1.getPaPermanentdisablementSuminsured())) {
					error.add(new Error("05", "PaPermanentdisablementSuminsured", "Please Enter PaPermanentdisablementSuminsured"));
				} else if (!req1.getPaMedicalSuminsured().matches("[0-9.]+")) {
					error.add(new Error("05", "PaPermanentdisablementSuminsured", "Please Enter Valid Number In PaPermanentdisablementSuminsured"));
				}
				else if (req1.getPaPermanentdisablementSuminsured().equalsIgnoreCase("0") ) {
					error.add(new Error("05", "PaPermanentdisablementSuminsured", "Please Enter PaPermanentdisablementSuminsured above 0"));
				}
				
				if (StringUtils.isBlank(req1.getPaTotaldisabilitySuminsured())) {
					error.add(new Error("06", "PaTotaldisabilitySuminsured", "Please Enter PaTotaldisabilitySuminsured"));
				} else if (!req1.getPaMedicalSuminsured().matches("[0-9.]+")) {
					error.add(new Error("06", "PaTotaldisabilitySuminsured", "Please Enter Valid Number In PaTotaldisabilitySuminsured"));
				}
				else if (req1.getPaTotaldisabilitySuminsured().equalsIgnoreCase("0") ) {
					error.add(new Error("06", "PaTotaldisabilitySuminsured", "Please Enter PaTotaldisabilitySuminsured above 0"));
				}

				}
				}
			*/
			for(PersonalAccidentDetailsListReq req2:  req.getPersonaldetails()) {				
			
				row = row + 1 ;
				if (StringUtils.isBlank(req2.getPersonName())) {
					error.add(new Error("08", "PersonName", "Please Enter PersonName In Row No:" + row ));
				}
				
				else if (req2.getPersonName().length()>20) {
					error.add(new Error("08", "PersonName", "Please Enter PersonName within 20 Characters In Row No:" + row ));
				}
				else if ((StringUtils.isNotBlank(req2.getPersonName()))&&!req2.getPersonName().matches("[A-Z a-z]+")) {
					error.add(new Error("08", "PersonName", "Please Enter Valid Name In Person Name In Row No:" + row ));
				}
				
//				if (StringUtils.isNotBlank(req2.getHeight())) {
//					if ((StringUtils.isNotBlank(req2.getHeight()))&&!req2.getHeight().matches("[0-9.]+")) {
//						error.add(new Error("09", "Height", "Please Enter Valid Number In Height In Row No:" + row ));
//					}
//					else if ((StringUtils.isNotBlank(req2.getHeight()))&&req2.getHeight().equalsIgnoreCase("0") ) {
//						error.add(new Error("09", "Height", "Please Enter Height above 0 In Row No:" + row ));
//					}
//					else if ((StringUtils.isNotBlank(req2.getHeight()))&&(Integer.valueOf(req2.getHeight()))<120) {
//						error.add(new Error("09", "Height", "Please Enter Height above 120 CM In Row No:" + row ));
//					}
//				}
//				
//				if (StringUtils.isNotBlank(req2.getWeight())) {
//					if ((StringUtils.isNotBlank(req2.getWeight()))&&!req2.getWeight().matches("[0-9.]+")) {
//						error.add(new Error("10", "Weight", "Please Enter Valid Number In Weight In Row No:" + row ));
//					}
//					else if ((StringUtils.isNotBlank(req2.getWeight()))&&req2.getWeight().equalsIgnoreCase("0") ) {
//						error.add(new Error("10", "Weight", "Please Enter Weight above 0 In Row No:" + row ));
//					}
//					else if ((StringUtils.isNotBlank(req2.getWeight()))&&(Integer.valueOf(req2.getWeight()))<40) {
//						error.add(new Error("10", "Weight", "Please Enter Weight above 40 KG In Row No:" + row ));
//					}
//				}
				
				if (StringUtils.isBlank(req2.getSalary())) {
					error.add(new Error("12", "Salary", "Please Enter Salary"));
				}
				else if ((StringUtils.isNotBlank(req2.getSalary()))&&!req2.getSalary().matches("[0-9.]+")) {
					error.add(new Error("12", "Salary", "Please Enter Valid Number In Salary In Row No:" + row ));
				}
				else if ((StringUtils.isNotBlank(req2.getSalary())) && Double.valueOf(req2.getSalary()) <=0) {
					error.add(new Error("12", "Salary", "Please Enter Salary above zero In Row No:" + row ));
				}
				else {
					sumInsured = sumInsured.add(new BigDecimal(req2.getSalary()));
				}
				if (StringUtils.isBlank(req2.getOccupationId()))  {
					error.add(new Error("14", "OccupationId", "Please Enter OccupationId In Row No:" + row ));
				}
				if (StringUtils.isBlank(req2.getRiskId())) {
					error.add(new Error("15", "RiskId", "Please Enter RiskId In Row No:" + row ));
				}
				Date today = new Date();

				if (req2.getDob() == null) {
					error.add(new Error("11", "Dob", "Please Enter Dob In Row No:" + row ));

				} else if (req2.getDob().after(today)) {
					error.add(new Error("11", "Dob", "Please Enter Dob as Past Date In Row No:" + row ));

				}

				LocalDate localDate1 = req2.getDob().toInstant().atZone(ZoneId.systemDefault())
						.toLocalDate();
				LocalDate localDate2 = today.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

				Integer years = Period.between(localDate1, localDate2).getYears();
				if (years > 100) {
					error.add(new Error("11", "Dob", "Dob Not Accepted More than 100 Years In Row No:" + row ));

				}
				
				
			/*	if (StringUtils.isBlank(req2.getSumInsured())) {
					error.add(new Error("13", "SumInsured", "Please Enter SumInsured"));
				}
				else if (!req2.getSumInsured().matches("[0-9.]+")) {
					error.add(new Error("13", "SumInsured", "Please Enter Valid Number In SumInsured"));
				}
				else if (req2.getSumInsured().equalsIgnoreCase("0") ) {
					error.add(new Error("13", "SumInsured", "Please Enter SumInsured above 0"));
				}
			*/	
				
			}
			if((StringUtils.isNotBlank(req.getType()))&&req.getType().equalsIgnoreCase("WC")) {
				if(StringUtils.isNotBlank(quoteNo)  ) {
					if(buidingData.getWorkmenCompSuminsured()!=null && sumInsured.compareTo(buidingData.getWorkmenCompSuminsured()) > 0 ) {
						error.add(new Error("03", "SumINsured", " Total SumInsured Greater Workmen Compensation SumInsured In Row No:" + row  ));
					}
				}
				}
				

			if((StringUtils.isNotBlank(req.getType()))&&req.getType().equalsIgnoreCase("PI")) {
				if(StringUtils.isNotBlank(quoteNo)  ) {
					if(buidingData.getPersonalIntSuminsured()!=null && sumInsured.compareTo(buidingData.getPersonalIntSuminsured()) > 0 ) {
						error.add(new Error("03", "SumINsured", " Total SumInsured Greater Personal Intermnity SumInsured In Row No:" + row  ));
					}
				}
				}


			if((StringUtils.isNotBlank(req.getType()))&&req.getType().equalsIgnoreCase("PA")) {
				if(StringUtils.isNotBlank(quoteNo)  ) {
					if(accidentData.getSumInsured()!=null && sumInsured.compareTo(accidentData.getSumInsured()) > 0 ) {
						error.add(new Error("03", "SumINsured", " Total SumInsured Greater Personal Accident SumInsured In Row No:" + row  ));
					}
				}
				}
			
		}
		 catch (Exception e) {

				log.error(e);
				e.printStackTrace();
			}
			return error;
		}

	
	
	@Override
	public SuccessRes savepersonalaccident(PersonalAccidentSaveReq req) {
		SuccessRes res = new SuccessRes();
		DozerBeanMapper dozermapper = new DozerBeanMapper();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat idf = new SimpleDateFormat("yyMMddmmssSSS");
		SimpleDateFormat yf = new SimpleDateFormat("yyyy");
		try {
			PersonalAccident saveData = new PersonalAccident();
			Date entryDate = new Date();

			List<PersonalAccident> count = repo.findByQuoteNoAndType(req.getQuoteNo(),req.getType());
			
				repo.deleteAll(count);
			
			List<SectionMaster> section = sectionrepo.findBySectionIdOrderByAmendIdDesc(Integer.valueOf(req.getSectionId()));
			ListItemValue type = listrepo.findByItemTypeAndItemCode("PERSONAL",req.getType());
			

				saveData=dozermapper.map(req, PersonalAccident.class);
				saveData.setEntryDate(entryDate);
				saveData.setCreatedBy(req.getCreatedBy());
				saveData.setStatus("Y");
				saveData.setRequestReferenceNo(req.getRequestReferenceNo());
				saveData.setQuoteNo(req.getQuoteNo());	
				saveData.setSectionDesc(section.get(0).getSectionName());
				saveData.setDescription(req.getDescription());
				saveData.setTypeDesc(type.getItemValue());
				res.setSuccessId(req.getRequestReferenceNo());
				res.setResponse("Saved Successful");

			
			Integer personId=1;

			List<PersonalAccidentDetailsListReq> reqList =  req.getPersonaldetails()  ;
			
			Map<String,	List<PersonalAccidentDetailsListReq>> groupByRiskId = reqList.stream().collect(Collectors.groupingBy(PersonalAccidentDetailsListReq :: getRiskId))  ;
		
			
			for(String riskId : groupByRiskId.keySet()) {
				
				List<PersonalAccidentDetailsListReq> filterData =  groupByRiskId.get(riskId) ;

				
				BigDecimal sno = BigDecimal.ZERO ;
				for(PersonalAccidentDetailsListReq reqdata :filterData) {
			List<OccupationMaster> occupation = occupationrepo.findByOccupationId(Integer.valueOf(reqdata.getOccupationId()));
			sno = sno.add(BigDecimal.ONE);

			//	saveData.setSumInsured(new BigDecimal(reqdata.getSumInsured()));
			//	saveData.setPaDeathSuminsured(new BigDecimal(reqdata.getPaDeathSuminsured()));
			//	saveData.setPaPermanentdisablementSuminsured(new BigDecimal(reqdata.getPaPermanentdisablementSuminsured()));
			//	saveData.setPaMedicalSuminsured(new BigDecimal(reqdata.getPaMedicalSuminsured()));
			//	saveData.setPaTotaldisabilitySuminsured(new BigDecimal(reqdata.getPaTotaldisabilitySuminsured()));
				saveData.setSerialNo(sno);
				saveData.setDob(reqdata.getDob());
				saveData.setHeight(reqdata.getHeight()==null ? new BigDecimal(0) : new BigDecimal(reqdata.getHeight()));				
				saveData.setWeight(reqdata.getWeight()==null ? new BigDecimal(0) : new BigDecimal(reqdata.getWeight()));
				saveData.setSalary(new BigDecimal(reqdata.getSalary()));
				saveData.setOccupationDesc(occupation.get(0).getOccupationName());
				saveData.setOccupationId(reqdata.getOccupationId());
				saveData.setCategoryId(occupation.get(0).getCategoryId());
				saveData.setPersonId(personId.toString());
				saveData.setPersonName(reqdata.getPersonName());
 				saveData.setRiskId(Integer.valueOf(reqdata.getRiskId()));

				personId++;
				//Age Calculator
				Date dob= (reqdata.getDob());
				Calendar cal = Calendar.getInstance();
				Date today = new Date();
				long years = today.getYear()-dob.getYear();
		        int age = (int)years;
				saveData.setAge(age);
				repo.saveAndFlush(saveData);

				}
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
	public PersonalAccidentGetRes getpersonalaccident(PersonalAccidentGetReq req) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		PersonalAccidentGetRes res = new PersonalAccidentGetRes();
		DozerBeanMapper dozermapper = new DozerBeanMapper();
		try {
		PersonalAccident data = repo.findByQuoteNoAndRiskIdAndPersonIdAndSectionId(req.getQuoteNo(),
					Integer.valueOf(req.getRiskId()),req.getPersonId(),req.getSectionId());
		if(data!=null) {
			res = dozermapper.map(data, PersonalAccidentGetRes.class);
		//	res.setPaDeathSuminsured(data.getPaDeathSuminsured().toString());
		//	res.setPaMedicalSuminsured(data.getPaMedicalSuminsured().toString());
		//	res.setPaPermanentdisablementSuminsured(data.getPaMedicalSuminsured().toString());
		//	res.setPaTotaldisabilitySuminsured(data.getPaTotaldisabilitySuminsured().toString());
		//	res.setSumInsured(data.getSumInsured().toString());
			res.setRiskId(data.getRiskId().toString());
			res.setSerialNo(data.getSerialNo().toString());
			res.setDob(data.getDob());
			res.setAge(data.getAge().toString());
			res.setHeight(data.getHeight().toString());
			res.setWeight(data.getWeight().toString());
			res.setEntryDate(data.getEntryDate());	
			res.setUpdatedDate(data.getUpdatedDate());	
			res.setSalary(data.getSalary().toString());
			res.setOccupationId(data.getOccupationId());
			
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
	public PersonalAccidentGetAllRes getallpersonalaccident(PersonalAccidentGetAllReq req) {
		PersonalAccidentGetAllRes res = new PersonalAccidentGetAllRes();
		DozerBeanMapper dozermapper  = new DozerBeanMapper();
		try {
			List<PersonalAccident> datas = repo.findByQuoteNoAndSectionId(req.getQuoteNo(),req.getSectionId());

			if(datas!=null  && datas.size()>0 ) {
			
			res = dozermapper.map(datas.get(0),PersonalAccidentGetAllRes.class);			
			res.setQuoteNo(datas.get(0).getQuoteNo());
			res.setRequestReferenceNo(datas.get(0).getRequestReferenceNo());
			res.setSectionId(datas.get(0).getSectionId());				
			res.setSectionDesc(datas.get(0).getSectionDesc());
			res.setSerialNo(datas.get(0).getSerialNo().toString());
			res.setType(datas.get(0).getType());
			res.setTypeDesc(datas.get(0).getTypeDesc());
			List<PersonalDetailsGetallRes> resList1 = new ArrayList<PersonalDetailsGetallRes>();;
			for(PersonalAccident data : datas) {
				PersonalDetailsGetallRes res1 = new PersonalDetailsGetallRes();
				res1=dozermapper.map(data, PersonalDetailsGetallRes.class);
			//	res1.setPaDeathSuminsured(data.getPaDeathSuminsured().toString());
			//	res1.setPaMedicalSuminsured(data.getPaMedicalSuminsured().toString());
			//	res1.setPaPermanentdisablementSuminsured(data.getPaPermanentdisablementSuminsured().toString());
			//	res1.setPaTotaldisabilitySuminsured(data.getPaTotaldisabilitySuminsured().toString());
			//	res1.setSumInsured(data.getSumInsured().toString());
				res1.setDob(data.getDob());
				res1.setAge(data.getAge().toString());
				res1.setHeight(data.getHeight().toString());
				res1.setWeight(data.getWeight().toString());
				res1.setSalary(data.getSalary().toString());			
				res1.setOccupationId(data.getOccupationId());
				res1.setRiskId(data.getRiskId().toString());

				resList1.add(res1);
			}
			res.setPersonalDeatils(resList1);
		
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
