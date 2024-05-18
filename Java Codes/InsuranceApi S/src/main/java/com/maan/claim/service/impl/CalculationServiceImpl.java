package com.maan.claim.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.maan.claim.error.Error;

import com.maan.claim.req.CalculationReq;
import com.maan.claim.res.CalculationRes;
import com.maan.claim.service.CalculationService;


@Service
public class CalculationServiceImpl implements CalculationService {
	private Logger log = LogManager.getLogger(CalculationServiceImpl.class);
	Gson json = new Gson();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public CalculationRes getCalculation(CalculationReq req) {

		CalculationRes calRes = new CalculationRes();
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
		/*	BigDecimal c  = new BigDecimal ("10");
			c.add(new BigDecimal ("10") );
			c.subtract(subtrahend);
			c.multiply(multiplicand);
			c.divide(divisor);
			if( c.compareTo(new BigDecimal ("20") ) > 0) {
				
			} */
			int vehAge = Integer.valueOf(req.getVehicleAge());
		//	Date dob = sdf.parse(req.getDriverDob());
			LocalDate driDOB =  LocalDate.parse(req.getDriverDob() ,df);
			LocalDate curDate = LocalDate.now();
			long sumInsuredAmount = Integer.valueOf(req.getSumInsuredAmount());
			int vehBodyType = Integer.valueOf(req.getVehicleBodyType());

			vehAge = 2022-vehAge ;

			float vehPercent = 0;
			float driPercent = 0;
			float amountPercent = 0;
			float bodyTypeRate = 0;

			// Validate Vehical Age
			if (vehAge <= 5) {
				vehPercent = 5;
			} else {
				vehPercent = 10;
			}
			// Validate Driver Age
			if ((driDOB != null) && (curDate != null)) {
				int age = Period.between(driDOB, curDate).getYears();
				if (age >= 18 && age <= 25) {
					driPercent = 10;
				} else if (age >= 26 && age <= 40) {
					driPercent = 5;
				}
			}
			// Validate Sum Insured Amount
			if (sumInsuredAmount >= 1 && sumInsuredAmount <= 100000) {
				amountPercent = 10;
			} else if (sumInsuredAmount >= 100001 && sumInsuredAmount <= 200000) {
				amountPercent = 20;
			} else if (sumInsuredAmount >= 200001 && sumInsuredAmount <= 500000) {
				amountPercent = 35;
			}
			// Validate Vehicle Body Type
			if (vehBodyType == 1) {
				String name = "Saloon";
				bodyTypeRate = 1.5f;
			} else if (vehBodyType == 2) {
				String name = " 4 Wheeler";
				bodyTypeRate = 2f;
			} else if (vehBodyType == 3) {
				String name = "Sports";
				bodyTypeRate = 3f;
			}

			// Calculation

			vehPercent = bodyTypeRate * vehPercent / 100;
			driPercent = bodyTypeRate * driPercent / 100;
			amountPercent = bodyTypeRate * amountPercent / 100;

			float total = vehPercent + driPercent + amountPercent;

			float totalPremium = sumInsuredAmount * total;
			
			
			calRes.setTotalPremium(totalPremium);

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;

		}
		return calRes;
	}
	
	@Override
	public List<Error> validateReq(CalculationReq req) {
		List<Error> errors = new ArrayList<Error>();
		try {
			if (StringUtils.isBlank(req.getVehicleAge())) {
				errors.add(new Error("01", "Vehicle Age", "Please Enter Vehicle Age"));
			} else if (Integer.valueOf(req.getVehicleAge()) > 2022) {
				errors.add(new Error("01", "Vehicle Age", "Please Enter Valid Vehicle Age"));
			}
			Date today = new Date();
			if (StringUtils.isBlank(req.getDriverDob()))
				errors.add(new Error("02", "Driver Dob", "please enter  Date Of Birth"));
			else if (!req.getDriverDob().matches("([0-9]{2})/([0-9]{2})/([0-9]{4})"))
				errors.add(new Error("02", "Driver Dob",
						"Effective Date format should be dd/MM/yyyy only allowed . Example :- 15/12/2022"));
			else if (sdf.parse(req.getDriverDob()).before(today))
				errors.add(new Error("02", "Driver Dob", "Effective Date Before Today Not Allowed"));

			if (StringUtils.isBlank(req.getSumInsuredAmount())) {
				errors.add(new Error("03", "SumInsuredAmount", "Please Enter SumInsuredAmount"));
			} else if (Integer.valueOf(req.getSumInsuredAmount())>500000) {
				errors.add(new Error("03", "SumInsuredAmount", "Please Enter valid SumInsuredAmount"));
			}
			
			if (StringUtils.isBlank(req.getVehicleBodyType())) {
				errors.add(new Error("04", "VehicleBodyType", "Please Enter VehicleBodyType"));
			} else if (!req.getVehicleBodyType().matches("([1-3])")) {
				errors.add(new Error("04", "Vehicle Age", "Please Enter Valid Vehicle Age"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			errors.add(new Error("01", "Common Error", e.getMessage()));

		}
		return errors;
	}

	/*
	 
	// SAVE
	@Transactional
	@Override
	public SuccessRes savePolicyRiderDetails(PolicyRiderDetailsSaveReq req) {
		SuccessRes res = new SuccessRes();
		ModelMapper mapper = new ModelMapper();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dbFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			PolicyRiderDetails savePolicyRiderDetails = new PolicyRiderDetails();

			int policyId = 0;
			Date entryDate = null;
			if (StringUtils.isBlank(req.getPolicyId())) {

				// Save
				Long totalCount = policyRepo.count();
				policyId = Integer.valueOf(totalCount.toString()) + 1;

				entryDate = new Date();
				res.setResponse("Saved Succesfully");

			} else {
				// Update
				policyId = Integer.valueOf(req.getPolicyId());
				PolicyRiderDetails findData = policyRepo.findByPolicyId(policyId);

				entryDate = findData.getEntryDate();
				res.setResponse("Updated Succesfully");
			}

			// Mapper
			savePolicyRiderDetails = mapper.map(req, PolicyRiderDetails.class);
			savePolicyRiderDetails.setStatus("Y");
			savePolicyRiderDetails.setPolicyId(policyId);
			savePolicyRiderDetails.setEntryDate(entryDate);

			policyRepo.save(savePolicyRiderDetails);
			log.info("Saved Details is ---> " + json.toJson(savePolicyRiderDetails));

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;

		}
		return res;
	}

	// Get By ID
	@Override
	public PolicyRiderDetailsRes getPolicyRiderDetailsById(PolicyRiderDetailsGetReq req) {
		PolicyRiderDetailsRes res = new PolicyRiderDetailsRes();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ModelMapper mapper = new ModelMapper();
		try {
			Integer policyId = 0;
			policyId=Integer.valueOf(req.getPolicyId());
		

			PolicyRiderDetails data = policyRepo.findByPolicyId(policyId);

			res = mapper.map(data, PolicyRiderDetailsRes.class);

			res.setEntryDate(data.getEntryDate() == null ? "" : sdf.format(data.getEntryDate()));

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;

		}
		return res;
	}

	// GET ALL
	@Override
	public List<PolicyRiderDetailsRes> getAllPolicyRiderDetails(PolicyRiderDetailsGetAllReq req) {
		List<PolicyRiderDetailsRes> resList = new ArrayList<PolicyRiderDetailsRes>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ModelMapper mapper = new ModelMapper();
		try {
			// Limit , Offset
			int limit = StringUtils.isBlank(req.getLimit()) ? 0 : Integer.valueOf(req.getLimit());
			int offset = StringUtils.isBlank(req.getOffset()) ? 10 : Integer.valueOf(req.getOffset());
			Pageable paging = PageRequest.of(limit, offset, Sort.by("entryDate").descending());

			// Find
			Page<PolicyRiderDetails> policyDetails = policyRepo.findAll(paging);

			// Map
			for (PolicyRiderDetails data : policyDetails.getContent()) {
				PolicyRiderDetailsRes res = new PolicyRiderDetailsRes();

				res = mapper.map(data, PolicyRiderDetailsRes.class);
				res.setEntryDate(data.getEntryDate() == null ? "" : sdf.format(data.getEntryDate()));

				resList.add(res);
			}

		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			return null;

		}
		return resList;
	}
	 */
}
