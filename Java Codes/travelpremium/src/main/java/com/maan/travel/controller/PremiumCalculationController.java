package com.maan.travel.controller;


import java.util.Collections;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.maan.travel.repository.VisTravelRatingRepository;
import com.maan.travel.req.PremiumCalculationReq;
import com.maan.travel.req.PrintReqService;
import com.maan.travel.res.CommonRes;
import com.maan.travel.res.PremiumCalculationRes;
import com.maan.travel.service.PremiumCalculationService;
import com.maan.travel.serviceimpl.PremiumCalculationServiceImpl;


public class PremiumCalculationController {

	
	@Autowired
	private PremiumCalculationService entityService;

	@Autowired
	private com.maan.travel.req.PrintReqService reqPrinter;
	
	private Logger log = LogManager.getLogger(PremiumCalculationServiceImpl.class);
	
	
	@Autowired
	private VisTravelRatingRepository repository;
	
	@Autowired
	private  PrintReqService dateformat;
	
	
	@PostMapping("/premiumcalculation")
	public ResponseEntity<CommonRes> getPremiumCalculation(@RequestBody PremiumCalculationReq req) {
		CommonRes data = new CommonRes();

	// Get All
	List<PremiumCalculationRes> res = entityService.getPremiumCalculation(req);
	data.setCommonResponse(res);
	data.setIsError(false);
	data.setErrorMessage(Collections.emptyList());
	data.setMessage("Success");

	if (res != null) {
	return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);
	} else {
	return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	}


	
}

	
}
