package com.maan.crm.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.maan.crm.bean.ClaimLoginMaster;
import com.maan.crm.bean.ClientAddressDetails;
import com.maan.crm.bean.InsuranceCompanyMaster;
import com.maan.crm.bean.LeadDetails;
import com.maan.crm.bean.OldPolicyDetails;
import com.maan.crm.bean.ProspectDetails;
import com.maan.crm.bean.VehicleDetails;
import com.maan.crm.notification.mail.dto.MailFramingReq;
import com.maan.crm.notification.service.impl.MailThreadServiceImpl;
import com.maan.crm.repository.ClaimLoginMasterRepository;
import com.maan.crm.repository.ClientAddressDetailsRepository;
import com.maan.crm.repository.InsuranceCompanyMasterRepository;
import com.maan.crm.repository.LeadRepository;
import com.maan.crm.repository.OldPolicyRepository;
import com.maan.crm.repository.ProspectDetailsRepository;
import com.maan.crm.repository.VehicleDetailsRepository;
import com.maan.crm.req.ClientLeadReq;
import com.maan.crm.req.CrmLeadSaveReq;
import com.maan.crm.req.LeadBulkEditReq;
import com.maan.crm.req.LeadDetailsGetAllReq;
import com.maan.crm.req.LeadDetailsGetReq;
import com.maan.crm.req.LeadViewReq;
import com.maan.crm.req.OldPolicyGetAllReq;
import com.maan.crm.req.OldPolicyGetReq;
import com.maan.crm.req.OldPolicySaveReq;
import com.maan.crm.req.VehicleDetailsGetAllReq;
import com.maan.crm.req.VehicleDetailsGetReq;
import com.maan.crm.req.VehicleDetailsSaveReq;
import com.maan.crm.res.CrmLeadRes;
import com.maan.crm.res.CrmLeadSuccessRes;
import com.maan.crm.res.DropDownRes;
import com.maan.crm.res.LeadViewRes;
import com.maan.crm.res.OldPolicyRes;
import com.maan.crm.res.SuccessRes;
import com.maan.crm.res.VehicleDetailsGridRes;
import com.maan.crm.res.VehicleDetailsRes;
import com.maan.crm.service.LeadService;
import com.maan.crm.util.error.Error;

@Service
@Transactional
public class LeadServiceImpl implements LeadService {

	@Autowired
	private LeadRepository repository;

	@Autowired
	private VehicleDetailsRepository vehRepo;

	@Autowired
	private OldPolicyRepository repo;
	
	@Autowired
	private ClientAddressDetailsRepository clientAddRepo;
	
	@Autowired
	private ProspectDetailsRepository prospectdetailsrepositoryl;

	@Autowired
	private InsuranceCompanyMasterRepository insRepo;
	
	@Autowired
	private ClientAddressDetailsRepository clientAddrRepo;
	
	@Autowired
	private MailThreadServiceImpl mailThreadService ;
	
	Gson json = new Gson();

	@Autowired
	private ClaimLoginMasterRepository loginRepo;
	
	private Logger log = LogManager.getLogger(LeadServiceImpl.class);
	
	// Validation
	@Override
	public List<Error> validateCrmLead(CrmLeadSaveReq req) {
		List<Error> errors = new ArrayList<Error>();
		try {
			if (StringUtils.isNotBlank(req.getLeadId())) {
				if (!StringUtils.isNumeric(req.getLeadId())) {
					errors.add(new Error("01", "Lead Id", "Please Enter Valid Lead Id "));
				}
			}
			if (req.getClientRefNo() == null || StringUtils.isBlank(req.getClientRefNo())) {
				errors.add(new Error("02", "Client Ref No", "Please Enter Client Ref No"));
			} else if (req.getClientRefNo().length() > 50) {
				errors.add(new Error("02", "Client Ref No", "Please Enter Client Ref No within 50 Characters"));
			}
			if (req.getBusinessType() == null || StringUtils.isBlank(req.getBusinessType())) {
				errors.add(new Error("03", "Business Type", "Please Enter Business Type"));
			} else if (req.getBusinessType().length() > 100) {
				errors.add(new Error("03", "Business Type", "Please Enter Business Type within 100 Characters"));
			}
			if (req.getBusinessTypeId() == null || StringUtils.isBlank(req.getBusinessTypeId())) {
				errors.add(new Error("04", "Business Type Id", "Please Enter Business Type Id"));
			}
			if (req.getAssigntoGroup() == null || StringUtils.isBlank(req.getAssigntoGroup())) {
				errors.add(new Error("05", "Assign To Group", "Please Enter Assign to Group"));
			} else if (req.getAssigntoGroup().length() > 100) {
				errors.add(new Error("05", "Assign to Group", "Please Enter Assign to Group within 100 Characters"));
			}
			if (req.getAssigntoGroupId() == null || StringUtils.isBlank(req.getAssigntoGroupId())) {
				errors.add(new Error("06", "Assign To Group Id", "Please Enter Assign To Group Id"));
			} else if (!StringUtils.isNumeric(req.getAssigntoGroupId())) {
				errors.add(new Error("06", "Assign To Group Id", "Please Enter Assign To Group Id in numbers"));
			}

			if (req.getAssigntoUser() == null || StringUtils.isBlank(req.getAssigntoUser())) {
				errors.add(new Error("07", "Assign To User", "Please Enter Assign to User"));
			} else if (req.getAssigntoUser().length() > 100) {
				errors.add(new Error("07", "Assign to User", "Please Enter Assign to User within 100 Characters"));
			}
			if (req.getAssigntoUserId() == null || StringUtils.isBlank(req.getAssigntoUserId())) {
				errors.add(new Error("08", "Assign To User Id", "Please Enter Assign To User Id"));
			} else if (!StringUtils.isNumeric(req.getAssigntoUserId())) {
				errors.add(new Error("08", "Assign To User Id", "Please Enter Assign To User Id in numbers"));
			}
			if (req.getBrokenPolicy() == null || StringUtils.isBlank(req.getBrokenPolicy())) {
				errors.add(new Error("09", "Broken Policy", "Please Enter Broken Policy"));
			} else if (req.getBrokenPolicy().length() > 100) {
				errors.add(new Error("09", "Broken Policy", "Please Enter Broken Policy within 100 Characters"));
			}
			if (req.getClassDesc() == null || StringUtils.isBlank(req.getClassDesc())) {
				errors.add(new Error("10", "Class Desc", "Please Enter Class Desc"));
			} else if (req.getClassDesc().length() > 100) {
				errors.add(new Error("10", "Class Desc", "Please Enter Class Desc within 100 Characters"));
			}
			if (req.getClassId() == null || StringUtils.isBlank(req.getClassId())) {
				errors.add(new Error("11", "Class Id", "Please Enter Class Id"));
			} else if (!StringUtils.isNumeric(req.getClassId())) {
				errors.add(new Error("12", "Class Id", "Please Enter Class Id in numbers"));
			}
			if (req.getClassification() == null || StringUtils.isBlank(req.getClassification())) {
				errors.add(new Error("12", "Classification", "Please Enter Classification"));
			} else if (req.getClassification().length() > 100) {
				errors.add(new Error("12", "Classification", "Please Enter Classification within 100 Characters"));
			}

			if (req.getClassificationId() == null || StringUtils.isBlank(req.getClassificationId())) {
				errors.add(new Error("13", "Classification Id", "Please Enter Classification Id"));
			} else if (!StringUtils.isNumeric(req.getClassificationId())) {
				errors.add(new Error("13", "Classification Id", "Please Classification Id in numbers"));
			}
			if (req.getDueDate() == null || StringUtils.isBlank(req.getDueDate())) {
				errors.add(new Error("14", "Due Date", "Please Enter Due Date"));
			} else if (!req.getDueDate().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
				errors.add(new Error("14", "Due Date",
						"Due Date format should be dd/MM/yyyy only allowed . Example :- 15/12/2022"));
			}
			if (req.getLeadGenDate() == null || StringUtils.isBlank(req.getLeadGenDate())) {
				errors.add(new Error("15", "Lead Gen Date", "Please Enter Lead Gen Date"));
			} else if (!req.getLeadGenDate().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
				errors.add(new Error("15", "Lead Gen Date",
						"Lead Gen Date format should be dd/MM/yyyy only allowed . Example :- 15/12/2022"));
			}
			if (req.getOthertype() == null || StringUtils.isBlank(req.getOthertype())) {
				errors.add(new Error("16", "Other Type", "Please Enter Other Type"));
			} else if (req.getOthertype().length() > 100) {
				errors.add(new Error("16", "Other Type", "Please Enter Other Type within 100 Characters"));
			}
			if (req.getOthertypeId() == null || StringUtils.isBlank(req.getOthertypeId())) {
				errors.add(new Error("17", "Other Type Id", "Please Enter Other Type Id"));
			}
			if (req.getPolicyType() == null || StringUtils.isBlank(req.getPolicyType())) {
				errors.add(new Error("18", "Policy Type", "Please Enter Policy Type"));
			} else if (req.getPolicyType().length() > 100) {
				errors.add(new Error("18", "Policy Type", "Please Enter Policy Type within 100 Characters"));
			}
			if (req.getPolicyTypeId() == null || StringUtils.isBlank(req.getPolicyTypeId())) {
				errors.add(new Error("19", "Policy Type Id", "Please Enter Policy Type Id"));
			} else if (!StringUtils.isNumeric(req.getPolicyTypeId())) {
				errors.add(new Error("19", "Policy Type Id", "Please Enter Policy  Type Id in numbers"));
			}
			if (req.getPos() == null || StringUtils.isBlank(req.getPos())) {
				errors.add(new Error("20", "POS", "Please Enter POS"));
			} else if (req.getPos().length() > 100) {
				errors.add(new Error("20", "POS", "Please Enter POS within 100 Characters"));
			}
			if (req.getPosId() == null || StringUtils.isBlank(req.getPosId())) {
				errors.add(new Error("21", "POS Id", "Please Enter POS Id"));
			} else if (!StringUtils.isNumeric(req.getPosId())) {
				errors.add(new Error("21", "Assign To POS Id", "Please Enter Assign To POS Id in numbers"));
			}
			if (req.getReferenceName() == null || StringUtils.isBlank(req.getReferenceName())) {
				errors.add(new Error("22", "Reference Name", "Please Enter Reference Name"));
			} else if (req.getReferenceName().length() > 100) {
				errors.add(new Error("22", "Reference Name", "Please Enter Reference Name within 100 Characters"));
			}
			if (req.getReferredby() == null || StringUtils.isBlank(req.getReferredby())) {
				errors.add(new Error("23", "ReferredBy", "Please Enter Referred By"));
			} else if (req.getReferredby().length() > 100) {
				errors.add(new Error("23", "ReferredBy", "Please Enter ReferredBy within 100 Characters"));
			}
			if (req.getReferredbyId() == null || StringUtils.isBlank(req.getReferredbyId())) {
				errors.add(new Error("24", "Referred By Id", "Please Enter Referred By Id"));
			} else if (!StringUtils.isNumeric(req.getReferredbyId())) {
				errors.add(new Error("24", "Referred By Id", "Please Enter Referred By Id in numbers"));
			}
			if (req.getRemarks().length() > 100) {
				errors.add(new Error("25", "Remarks", "Please Enter Remarks  within 100 Characters"));
			}
			if (req.getSource() == null || StringUtils.isBlank(req.getSource())) {
				errors.add(new Error("26", "Source", "Please Enter Source"));
			} else if (req.getSource().length() > 100) {
				errors.add(new Error("26", "Source", "Please Enter Source within 100 Characters"));
			}
			if (req.getSourceId() == null || StringUtils.isBlank(req.getSourceId())) {
				errors.add(new Error("27", "Source Id", "Please Enter Source Id"));
			} else if (!StringUtils.isNumeric(req.getSourceId())) {
				errors.add(new Error("27", "Source Id", "Please Enter Source Id in numbers"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is --->" + e.getMessage());
			return errors;
		}
		return errors;
	}

// Save

	@Override
	@Transactional
	public CrmLeadSuccessRes saveCrmLead(CrmLeadSaveReq req) {
		CrmLeadSuccessRes res = new CrmLeadSuccessRes();
		LeadDetails entity = new LeadDetails();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dbf = new SimpleDateFormat("yyyy-MM-dd");
		ModelMapper mapper = new ModelMapper();
		Integer leadId = 0;
		Date entryDate = null;
		try {
			req.setDueDate(dbf.format(sdf.parse(req.getDueDate())));
			req.setLeadGenDate(dbf.format(sdf.parse(req.getLeadGenDate())));

			entity = mapper.map(req, LeadDetails.class);
			entity.setStatus("Y");

			if (StringUtils.isBlank(req.getLeadId())) {
				Long totalLeadCount = repository.count();
				leadId = Integer.valueOf(totalLeadCount.toString()) + 10001;
				entryDate = new Date();
				res.setResponse("Saved Successfully ");
				res.setLeadid(Integer.valueOf(leadId).toString());
				entity.setEntryDate(entryDate);
				entity.setLeadId(leadId);
			} else {
				// Update
				leadId = Integer.valueOf(req.getLeadId());
				LeadDetails data = repository.findByLeadId(leadId);
				entryDate = data.getEntryDate();
				res.setResponse("Updated Successfully ");
				res.setLeadid(Integer.valueOf(leadId).toString());
				entity.setEntryDate(entryDate);
				entity.setLeadId(leadId);
			}

			repository.saveAndFlush(entity);
			log.info("Saved Details is ---> " + json.toJson(entity));
			
			//Thread To Trigger Mail
			List<ClientAddressDetails>  clientAddrDetails = clientAddrRepo.findByClientRefNo(req.getClientRefNo());		
			InsuranceCompanyMaster companyData =  insRepo.findByInsId(req.getInsCompanyId());
			ClaimLoginMaster loginData = loginRepo.findByLoginId(req.getCreatedBy());
			
			List<String>  ccMails = new ArrayList<String>();
			ccMails.add(companyData.getInsEmail());
			ccMails.add(loginData.getUserMail());
					
			List<String>  toMails = new ArrayList<String>();
			for (ClientAddressDetails data : clientAddrDetails) {
				String  toClientMails =	data.getEmailId();
			 	toMails.add(toClientMails);
			}  

			Map<String, Object>  keys = new HashMap<String, Object>();
			keys.put("LEAD_ID", leadId==null?"":leadId.toString());
						
			// Set Mail Request 
			MailFramingReq mailFrameReq = new MailFramingReq(); 
			mailFrameReq.setInsId(req.getInsCompanyId());
			mailFrameReq.setNotifTemplateId("LEAD_INFO");
			mailFrameReq.setKeys(keys);	
			mailFrameReq.setMailCc(ccMails);
			mailFrameReq.setMailTo(toMails);
			mailFrameReq.setMailRegards(companyData.getRegards());
			mailFrameReq.setStatus(res.getResponse());
			
			log.info("{ Mail Pushed SuccessFully . LeadId is ---> " + leadId + " ; ClientRefNo is --->" + req.getClientRefNo() + " }"); 
		//			mailFrameService.sendSms(mailReq);
			mailThreadService.threadToSendMail(mailFrameReq); 
			
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;
		}
		return res;
	}

/// Get All Lead 
	@Override
	public List<CrmLeadRes> getAllLead(LeadDetailsGetAllReq req) {
		List<CrmLeadRes> resList = new ArrayList<CrmLeadRes>();
		ModelMapper mapper = new ModelMapper();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			int limit = StringUtils.isBlank(req.getLimit()) ? 0 : Integer.valueOf(req.getLimit());
			int offset = StringUtils.isBlank(req.getOffset()) ? 1000 : Integer.valueOf(req.getOffset());
			Pageable paging = PageRequest.of(limit, offset, Sort.by("entryDate").descending());
			Page<LeadDetails> leadDetails = repository.findByInsCompanyIdAndBranchCode(paging, req.getInsId(),
					req.getBranchCode());

			for (LeadDetails data : leadDetails) {
				CrmLeadRes res = new CrmLeadRes();
				mapper.map(data, res);
				resList.add(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is ---> " + e.getMessage());
			return null;
		}
		return resList;

	}

// Get by Lead Id
	@Override
	public CrmLeadRes getLead(LeadDetailsGetReq req) {
		CrmLeadRes res = new CrmLeadRes();
		ModelMapper mapper = new ModelMapper();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			LeadDetails data = repository.findByLeadId(Integer.valueOf(req.getLeadId()));

			mapper.map(data, res);

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is ---> " + e.getMessage());
			return null;
		}
		return res;

	}

	// Validate Old Policy Details

	@Override
	public List<Error> validateOldPolicy(OldPolicySaveReq req) {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Error> errors = new ArrayList<Error>();
		try {
			if (StringUtils.isNotBlank(req.getLeadId())) {
				if (!StringUtils.isNumeric(req.getLeadId())) {
					errors.add(new Error("01", "Lead Id", "Please Enter Valid Lead Id "));
				}
			}

			if (req.getOldCommisBasePremium() == null || StringUtils.isBlank(req.getOldCommisBasePremium())) {
				errors.add(new Error("02", "Old Commission Base Premium", "Please Enter Old Commission Base Premium"));
			} else if (!req.getOldCommisBasePremium().matches("[0-9.]+")) {
				errors.add(new Error("02", "Old Commission Premium",
						"Please Enter Old Commission Premium in Correct Format"));
			}

			if (req.getOldDiscountPercent() == null || StringUtils.isBlank(req.getOldDiscountPercent())) {
				errors.add(new Error("03", "Old Discount Percent", "Please Enter Old Discount Percent"));
			} else if (!req.getOldDiscountPercent().matches("[0-9.]+")) {
				errors.add(
						new Error("03", "Old Discount Percent", "Please Enter Old Discount Percent in Correct Format"));
			}
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, -1);
			Date yesterday = cal.getTime();

			Date a = sdf.parse(req.getOldExpiryDate());
			if (req.getOldExpiryDate() == null || StringUtils.isBlank(req.getOldExpiryDate().toString())) {
				errors.add(new Error("04", "Old Expiry Date", "Please Enter Old Expiry Date"));
			} else if (a.after(yesterday)) {
				errors.add(new Error("04", "Old Expiry Date", "Please Enter Past Date as Old Expiry Date"));
			} else if (!req.getOldExpiryDate().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
				errors.add(new Error("04", "Old Expiry Date",
						"Old Expiry Date format should be dd/MM/yyyy only allowed . Example :- 15/12/2022"));
			}

			if (req.getOldGst() == null || StringUtils.isBlank(req.getOldGst())) {
				errors.add(new Error("05", "Old GST", "Please Enter Old GST"));
			} else if (!req.getOldGst().matches("[0-9.]+")) {
				errors.add(new Error("05", "Old GST", "Please Enter Old GST in Correct Format"));
			}

			if (req.getOldnoClaimBonus() == null || StringUtils.isBlank(req.getOldnoClaimBonus())) {
				errors.add(new Error("06", "Old No Claim Bonus", "Please Enter Old No Claim Bonus"));
			} else if (!req.getOldnoClaimBonus().matches("[0-9.]+")) {
				errors.add(new Error("06", "Old No Claim Bonus", "Please Enter Old No Claim Bonus in Correct Format"));
			}
			if (req.getOldOtherPremium() == null || StringUtils.isBlank(req.getOldOtherPremium())) {
				errors.add(new Error("07", "Old No Claim Bonus", "Please Enter Old No Claim Bonus"));
			}

			else if (!req.getOldOtherPremium().matches("[0-9.]+")) {
				errors.add(new Error("07", "Old Other Premium", "Please Enter Old Other Premium"));
			}
			if (req.getOldPolicyAddiInfo() == null || StringUtils.isBlank(req.getOldPolicyAddiInfo())) {
				errors.add(new Error("08", "Old Policy Addi Info", "Please Enter Old Policy Addi Info"));
			} else if (req.getOldPolicyAddiInfo().length() > 100) {
				errors.add(new Error("08", "Old Policy Addi Info",
						"Please Enter Old Policy Addi Info within 100 Characters"));
			}
			if (req.getOldPolicyNo() == null || StringUtils.isBlank(req.getOldPolicyNo())) {
				errors.add(new Error("09", "Old Policy No", "Please Enter Old Policy No"));
			}

			else if (req.getOldPolicyNo().length() > 100) {
				errors.add(new Error("09", "Old Policy No", "Please Enter Old Policy No within 100 Characters"));
			}
			if (req.getOldStartDate() == null || StringUtils.isBlank(req.getOldStartDate())) {
				errors.add(new Error("10", "Old Start Date", "Please Enter Old Start Date"));
			} else if (!req.getOldStartDate().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})")) {
				errors.add(new Error("10", "Old Start Date",
						"Old Start Date format should be dd/MM/yyyy only allowed . Example :- 15/12/2022"));
			}

			if (req.getOldSumInsured() == null || StringUtils.isBlank(req.getOldSumInsured())) {
				errors.add(new Error("11", "Old Sum Insured", "Please Enter Old Sum Insured"));
			}

			else if (!req.getOldSumInsured().matches("[0-9.]+")) {
				errors.add(new Error("11", "Old Sum Insured", "Please Enter Old Old Sum Insured in Correct Format"));
			}
			if (req.getOldTotalpremiumWithgst() == null || StringUtils.isBlank(req.getOldTotalpremiumWithgst())) {
				errors.add(new Error("12", "Old Total Premium With GST", "Please Enter Old Total Premium with GST"));
			} else if (!req.getOldTotalpremiumWithgst().matches("[0-9.]+")) {
				errors.add(new Error("12", "Old Total Premium With GST",
						"Please Enter Old Total Premium with GST in Correct Format"));
			}
			if (req.getOldTotalPremium() == null || StringUtils.isBlank(req.getOldTotalPremium())) {
				errors.add(new Error("13", "Old Total Premium", "Please Enter Old Total Premium"));
			}

			else if (!req.getOldTotalPremium().matches("[0-9.]+")) {
				errors.add(new Error("13", "Old Total Premium", "Please Enter Old Total Premium in Correct Format"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is --->" + e.getMessage());
			return errors;
		}
		return errors;
	}

	// Save Old Policy Details

	@Override
	public SuccessRes saveOldPolicy(OldPolicySaveReq req) {
		SuccessRes res = new SuccessRes();
		OldPolicyDetails entity = new OldPolicyDetails();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dbf = new SimpleDateFormat("yyyy-MM-dd");

		ModelMapper mapper = new ModelMapper();
		Date entryDate = null;
		try {
			OldPolicyDetails data = repo.findByOldPolicyNo(req.getOldPolicyNo());
			if (data == null) {
				entryDate = new Date();
				res.setResponse("Saved Successfully ");
			} else {
				data = repo.findByOldPolicyNo(req.getOldPolicyNo());
				entryDate = data.getEntryDate();
				res.setResponse("Updated Successfully ");
			}

			entity.setOldPolicyNo(req.getOldPolicyNo());
			entity.setEntryDate(entryDate);
			entity.setOldExpiryDate(sdf.parse(req.getOldExpiryDate().toString()));
			entity.setOldStartDate(sdf.parse(req.getOldStartDate().toString()));
			entity.setOldComisBasePremium(Double.valueOf(req.getOldCommisBasePremium()));
			entity.setOldDiscountPercent(Integer.valueOf(req.getOldDiscountPercent()));
			entity.setOldGst(Double.valueOf(req.getOldGst()));
			entity.setOldnoClaimBonus(Double.valueOf(req.getOldnoClaimBonus()));
			entity.setOldOtherPremium(Double.valueOf(req.getOldOtherPremium()));
			entity.setOldPolicyAddiInfo(req.getOldPolicyAddiInfo());
			entity.setOldPolicyNo(req.getOldPolicyNo());
			entity.setOldSumInsured(Double.valueOf(req.getOldSumInsured()));
			entity.setOldTotalPremium(Double.valueOf(req.getOldTotalPremium()));
			entity.setOldTotalpremiumWithgst(Double.valueOf(req.getOldTotalpremiumWithgst()));
			entity.setCompanyId(req.getCompanyId());
			entity.setRegionCode(req.getRegionCode());
			entity.setBranchCode(req.getBranchCode());
			entity.setCreatedBy(req.getCreatedBy());
			entity.setUserType(req.getUserType());

			repo.save(entity);
			log.info("Saved Details is ---> " + json.toJson(entity));

		}

		catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is --->" + e.getMessage());
			return null;
		}
		return res;
	}

	// Drop Down Get Policy Details

	@Override
	public List<DropDownRes> getpolicydetails() {
		// TODO Auto-generated method stub
		return null;
	}

	// Get All Policy Details

	@Override
	public List<OldPolicyRes> getallOldPolicyDetails(OldPolicyGetAllReq req) {
		List<OldPolicyRes> resList = new ArrayList<OldPolicyRes>();
		ModelMapper mapper = new ModelMapper();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			// List<OldPolicyDetails> policyDetails = repo.OrderByEntryDateAsc();
			int limit = StringUtils.isBlank(req.getLimit()) ? 0 : Integer.valueOf(req.getLimit());
			int offset = StringUtils.isBlank(req.getOffset()) ? 10 : Integer.valueOf(req.getOffset());
			Pageable paging = PageRequest.of(limit, offset, Sort.by("entryDate").descending());
			Page<OldPolicyDetails> policyDetails = repo.findByCompanyIdAndBranchCode(paging, req.getInsId(),
					req.getBranchCode());

			for (OldPolicyDetails data : policyDetails) {
				OldPolicyRes res = new OldPolicyRes();
				mapper.map(data, res);

				res.setOldCommisBasePremium(
						data.getOldComisBasePremium() == null ? "" : data.getOldComisBasePremium().toString());
				res.setOldDiscountPercent(
						data.getOldDiscountPercent() == null ? "" : data.getOldDiscountPercent().toString());
				res.setOldExpiryDate(data.getOldExpiryDate() == null ? "" : sdf.format(data.getOldExpiryDate()));
				res.setOldGst(data.getOldGst() == null ? "" : data.getOldGst().toString());
				res.setOldnoClaimBonus(data.getOldnoClaimBonus() == null ? "" : data.getOldnoClaimBonus().toString());
				res.setOldOtherPremium(data.getOldOtherPremium() == null ? "" : data.getOldOtherPremium().toString());
				res.setOldPolicyAddiInfo(
						data.getOldPolicyAddiInfo() == null ? "" : data.getOldPolicyAddiInfo().toString());
				res.setOldPolicyNo(data.getOldPolicyNo() == null ? "" : data.getOldPolicyNo().toString());
				res.setOldStartDate(data.getOldStartDate() == null ? "" : sdf.format(data.getOldStartDate()));
				res.setOldSumInsured(data.getOldSumInsured() == null ? "" : data.getOldSumInsured().toString());
				res.setOldTotalPremium(data.getOldTotalPremium() == null ? "" : data.getOldTotalPremium().toString());
				res.setOldTotalpremiumWithgst(
						data.getOldTotalpremiumWithgst() == null ? "" : data.getOldTotalpremiumWithgst().toString());
				res.setEntryDate(data.getEntryDate() == null ? "" : sdf.format(data.getEntryDate()));
				resList.add(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is ---> " + e.getMessage());
			return null;
		}
		return resList;

	}

	// Get By Policy No

	@Override
	public OldPolicyRes getPolicyNo(OldPolicyGetReq req) {
		OldPolicyRes res = new OldPolicyRes();
		ModelMapper mapper = new ModelMapper();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			OldPolicyDetails data = repo.findByOldPolicyNo(req.getOldPolicyNo());

			res.setOldCommisBasePremium(
					data.getOldComisBasePremium() == null ? "" : data.getOldComisBasePremium().toString());
			res.setOldDiscountPercent(
					data.getOldDiscountPercent() == null ? "" : data.getOldDiscountPercent().toString());
			res.setOldExpiryDate(data.getOldExpiryDate() == null ? "" : sdf.format(data.getOldExpiryDate()));
			res.setOldGst(data.getOldGst() == null ? "" : data.getOldGst().toString());
			res.setOldnoClaimBonus(data.getOldnoClaimBonus() == null ? "" : data.getOldnoClaimBonus().toString());
			res.setOldOtherPremium(data.getOldOtherPremium() == null ? "" : data.getOldOtherPremium().toString());
			res.setOldPolicyAddiInfo(data.getOldPolicyAddiInfo() == null ? "" : data.getOldPolicyAddiInfo().toString());
			res.setOldPolicyNo(data.getOldPolicyNo() == null ? "" : data.getOldPolicyNo().toString());
			res.setOldStartDate(data.getOldStartDate() == null ? "" : sdf.format(data.getOldStartDate()));
			res.setOldSumInsured(data.getOldSumInsured() == null ? "" : data.getOldSumInsured().toString());
			res.setOldTotalPremium(data.getOldTotalPremium() == null ? "" : data.getOldTotalPremium().toString());
			res.setOldTotalpremiumWithgst(
					data.getOldTotalpremiumWithgst() == null ? "" : data.getOldTotalpremiumWithgst().toString());
			res.setEntryDate(data.getEntryDate() == null ? "" : sdf.format(data.getEntryDate()));
			res.setCompanyId(data.getCompanyId());
			res.setRegionCode(data.getRegionCode());
			res.setBranchCode(data.getBranchCode());
			res.setCreatedBy(data.getCreatedBy());
			res.setUserType(data.getUserType());
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is ---> " + e.getMessage());
			return null;
		}
		return res;

	}

	// validate vehicle details
	@Override
	public List<Error> validateVehicle(VehicleDetailsSaveReq req) {
		List<Error> errors = new ArrayList<Error>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			if (req.getCc() == null || StringUtils.isBlank(req.getCc())) {
				errors.add(new Error("01", "CC", "Please Enter CC"));
			} else if (req.getCc().length() > 100) {
				errors.add(new Error("01", "CC", "Please Enter CC within 100 Character"));
			}
			if (req.getColorId() == null || StringUtils.isBlank(req.getColorId())) {
				errors.add(new Error("02", "Color Id", "Please Enter Color Id"));
			} else if (!StringUtils.isNumeric(req.getColorId())) {
				errors.add(new Error("02", "Color Id", "Please Enter Color Id in numbers"));
			}
			if (req.getColorVariant() == null || StringUtils.isBlank(req.getColorVariant())) {
				errors.add(new Error("03", "Color Variant", "Please Enter Color Variant"));
			} else if (req.getColorVariant().length() > 100) {
				errors.add(new Error("03", "Color Variant", "Please Enter Color Variant within 100 Character"));
			}
			if (req.getEngineNo() == null || StringUtils.isBlank(req.getEngineNo())) {
				errors.add(new Error("04", "Engine No", "Please Enter Engine No"));
			} else if (req.getEngineNo().length() > 100) {
				errors.add(new Error("04", "Engine No", "Please Enter Engine No within 100 Character"));
			}
			if (req.getFueltype() == null || StringUtils.isBlank(req.getFueltype())) {
				errors.add(new Error("05", "Fuel Type", "Please Enter Fuel Type"));
			} else if (req.getFueltype().length() > 100) {
				errors.add(new Error("05", "Fuel Type", "Please Enter Fuel Type within 100 Character"));
			}
			if (req.getFueltypeId() == null || StringUtils.isBlank(req.getFueltypeId())) {
				errors.add(new Error("06", "Fuel Type Id", "Please Enter Fuel Type Id"));
			} else if (!StringUtils.isNumeric(req.getFueltypeId())) {
				errors.add(new Error("06", "Fuel Type Id", "Please Enter Fuel Type Id in numbers"));
			}
			if (req.getManufactureYear() == null || StringUtils.isBlank(req.getManufactureYear())) {
				errors.add(new Error("07", "Manufacture Year", "Please Enter Manufature Year"));
			} else if (!StringUtils.isNumeric(req.getManufactureYear())) {
				errors.add(new Error("07", "Manufature Year", "Please Enter Manufacture Year in numbers"));
			} else if (req.getManufactureYear().length() > 4) {
				errors.add(new Error("07", "Manufature Year", "Please Enter Manufature Year in numbers"));
			}
			if (req.getPlateChar() == null || StringUtils.isBlank(req.getPlateChar())) {
				errors.add(new Error("08", "Plate Char", "Please Enter Plate Char"));
			} else if (req.getPlateChar().length() > 100) {
				errors.add(new Error("08", "Plate Char", "Please Enter Plate Char within 100 Character"));
			}
			if (req.getPlateCharId() == null || StringUtils.isBlank(req.getPlateCharId())) {
				errors.add(new Error("09", "Plate Char", "Please Enter Plate Char"));
			}
			if (req.getPlateNo() == null || StringUtils.isBlank(req.getPlateNo())) {
				errors.add(new Error("10", "Plate No", "Please Enter Plate No"));
			} else if (!StringUtils.isNumeric(req.getPlateNo())) {
				errors.add(new Error("10", "Plate No", "Please Enter Plate No in numbers"));
			}
			if (req.getSeatingCapacity() == null || StringUtils.isBlank(req.getSeatingCapacity())) {
				errors.add(new Error("11", "Seating Capacity", "Please Enter Seating Capacity"));
			} else if (!StringUtils.isNumeric(req.getSeatingCapacity())) {
				errors.add(new Error("11", "Seating Capacity", "Please Enter Seating Capacity in numbers"));
			}
			if (req.getVehBodytype() == null || StringUtils.isBlank(req.getVehBodytype())) {
				errors.add(new Error("12", "Vehicle Body Type", "Please Enter Vehicle Body Type"));
			} else if (req.getVehBodytype().length() > 100) {
				errors.add(new Error("12", "Vehicle Body Type", "Please Enter Vehicle Body Type within 100 Character"));
			}
			if (req.getVehBodytypeId() == null || StringUtils.isBlank(req.getVehBodytypeId())) {
				errors.add(new Error("13", "Vehicle Body Type Id", "Please Enter Vehicle Body Type Id"));
			} else if (!StringUtils.isNumeric(req.getVehBodytypeId())) {
				errors.add(new Error("13", "Vehicle Body Type Id", "Please Enter Vehicle Body Type Id in numbers"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is --->" + e.getMessage());
			return errors;
		}
		return errors;
	}

	// Save vehicle Details
	@Override
	public SuccessRes saveVehicle(VehicleDetailsSaveReq req) {
		SuccessRes res = new SuccessRes();
		VehicleDetails entity = new VehicleDetails();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dbf = new SimpleDateFormat("yyyy-MM-dd");

		ModelMapper mapper = new ModelMapper();
		Date entryDate = null;
		try {
			VehicleDetails data = vehRepo.findByVehChassisNo(req.getVehChassisNo());
			if (data == null) {
				entryDate = new Date();
				res.setResponse("Saved Successfully ");
			} else {
				data = vehRepo.findByVehChassisNo(req.getVehChassisNo());
				entryDate = data.getEntryDate();
				res.setResponse("Updated Successfully ");
			}

			entity = mapper.map(req, VehicleDetails.class);

			entity.setVehChassisNo(req.getVehChassisNo());
			entity.setEntryDate(entryDate);
			vehRepo.save(entity);
			log.info("Saved Details is ---> " + json.toJson(entity));

		}

		catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is --->" + e.getMessage());
			return null;
		}
		return res;
	}

	// Get All Vehicle Details
	@Override
	public List<VehicleDetailsGridRes> getallVehicleDetails(VehicleDetailsGetAllReq req) {
		List<VehicleDetailsGridRes> resList = new ArrayList<VehicleDetailsGridRes>();
		ModelMapper mapper = new ModelMapper();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			int limit = StringUtils.isBlank(req.getLimit()) ? 0 : Integer.valueOf(req.getLimit());
			int offset = StringUtils.isBlank(req.getOffset()) ? 1000 : Integer.valueOf(req.getOffset());
			Pageable paging = PageRequest.of(limit, offset, Sort.by("entryDate").descending());
			Page<VehicleDetails> vehicleDetails = vehRepo.findByComapnyIdAndBranchCode(paging, req.getInsId(),
					req.getBranchCode());

			for (VehicleDetails data : vehicleDetails) {
				VehicleDetailsGridRes res = new VehicleDetailsGridRes();
				mapper.map(data, res);

				res.setEntryDate(data.getEntryDate() == null ? null : data.getEntryDate());

				resList.add(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is ---> " + e.getMessage());
			return null;
		}
		return resList;

	}

	// Get By Vehicle Details

	@Override
	public VehicleDetailsRes getChassisNo(VehicleDetailsGetReq req) {
		VehicleDetailsRes res = new VehicleDetailsRes();
		ModelMapper mapper = new ModelMapper();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			VehicleDetails data = vehRepo.findByVehChassisNo(req.getVehChassisNo());

			mapper.map(data, res);
			res.setEntryDate(data.getEntryDate() == null ? null : data.getEntryDate());

		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is ---> " + e.getMessage());
			return null;
		}
		return res;

	}

	// Drop Down Vehicle Details
	@Override
	public List<DropDownRes> getvehicledetails() {
		// TODO Auto-generated method stub
		return null;
	}

	// View Lead
	@Override
	public LeadViewRes viewLeadDetails(LeadViewReq req) {
		LeadViewRes res = new LeadViewRes();
		ModelMapper modelMapper = new ModelMapper();
		try {

			//Lead 
			LeadDetails lead = repository.findByLeadId(req.getLeadId());

			res.setLeadDetails(modelMapper.map(lead, CrmLeadRes.class));

			//Vehicle Details
			VehicleDetails vehDet = vehRepo.findByVehChassisNo(req.getVehChassisNo());

			res.setVehicleDetails(modelMapper.map(vehDet, VehicleDetailsRes.class));

			//Old Policy
			OldPolicyDetails oldPolicy = repo.findByOldPolicyNo(req.getOldPolicyNo());

			res.setOldPolicy(modelMapper.map(oldPolicy, OldPolicyRes.class));

		} catch (Exception e) {
			res = null;
			log.info("Exception Error", e.getMessage());
		}
		return res;

	}

	@Override
	public List<CrmLeadRes> viewClientLead(ClientLeadReq req) {
		List<CrmLeadRes> resList = new ArrayList<CrmLeadRes>();
		ModelMapper mapper = new ModelMapper();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		 List<LeadDetails> leadDetails = repository.findByClientRefNoOrderByEntryDateDesc(req.getClientRefNo());

			for (LeadDetails data : leadDetails) {
				CrmLeadRes res = new CrmLeadRes();
			res =	mapper.map(data, CrmLeadRes.class);
			
	//		res.setProspectCount(prospectdetailsrepositoryl.countByLeadId(data.getLeadId()).toString());
			resList.add(res);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception is ---> " + e.getMessage());
			return null;
		}
		return resList;

	}

	// Lead Bulk Edit
	@Override
	public List<Error> validateLead(LeadBulkEditReq req) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuccessRes bulkEditLead(LeadBulkEditReq req) {
		SuccessRes res = new SuccessRes();
		try {
			if (req.getLeadId()  != null && req.getLeadId().size() > 0) {
				List<Integer> leadIds = req.getLeadId();
				// Get List
				List<LeadDetails> getDatas = repository.findByLeadIdIn(leadIds);

				for (LeadDetails data : getDatas) {

					data.setAssigntoGroup(StringUtils.isBlank(req.getChangeAssigntoGroup()) ? data.getAssigntoGroup()
							: req.getChangeAssigntoGroup());
					data.setAssigntoGroupId(
							StringUtils.isBlank(req.getChangeAssignToGroupId()) ? data.getAssigntoGroupId() 
									: Integer.valueOf(req.getChangeAssignToGroupId()));
					data.setAssigntoUser(StringUtils.isBlank(req.getChangeAssigntoUser()) ? data.getAssigntoUser()
							: req.getChangeAssigntoUser());
					data.setAssigntoUserId(StringUtils.isBlank(req.getChangeAssigntoUserId()) ? data.getAssigntoUserId()
							: Integer.valueOf(req.getChangeAssigntoUserId()));
					data.setPos(StringUtils.isBlank(req.getChangePos()) ? data.getPos() : req.getChangePos());
					data.setPosId(StringUtils.isBlank(req.getChangePosId()) ? data.getPosId()
							: Integer.valueOf(req.getChangePosId()));
					data.setCalssification(StringUtils.isBlank(req.getChangeClassification()) ? data.getCalssification()
							: req.getChangeClassification());
					data.setClassificationId(
							StringUtils.isBlank(req.getChangeClassificationId()) ? data.getClassificationId()
									: Integer.valueOf(req.getChangeClassificationId()));
					data.setSource(
							StringUtils.isBlank(req.getChangeSource()) ? data.getSource() : req.getChangeSource());
					data.setSourceId(StringUtils.isBlank(req.getChangeSourceId()) ? data.getSourceId()
							: Integer.valueOf(req.getChangeSourceId()));
					repository.save(data);
					res.setResponse("Updated Succesfully");
				}

			} else {
				res.setResponse("Not Updated");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;

		}
		return res;
	}

}
