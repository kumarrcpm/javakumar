package com.maan.crm.controller;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maan.crm.repository.KumarCrmRepository;
import com.maan.crm.req.CrmLeadSaveReq;
import com.maan.crm.res.CommonCrmRes;
import com.maan.crm.res.CrmLeadSuccessRes;
import com.maan.crm.service.KumarCrmService;
import com.maan.crm.service.PrintReqService;
import com.maan.crm.serviceimpl.KumarCrmServiceImpl;
import com.maan.crm.error.Error;

@RestController
@RequestMapping("/api")

public class KumarCrmController {

	
	@Autowired
	private KumarCrmService entityService;

	@Autowired
	private com.maan.crm.service.PrintReqService reqPrinter;
	
	private Logger log = LogManager.getLogger(KumarCrmServiceImpl.class);
	
	@Autowired
	private KumarCrmRepository repository;
	
	@Autowired
	private  PrintReqService dateformat;

	@PostMapping(value = "/savelead")
	public ResponseEntity<CommonCrmRes> saveCrmCityMaster(@Valid @RequestBody CrmLeadSaveReq req) {
		reqPrinter.reqPrint(req);
		CommonCrmRes data = new CommonCrmRes();
		List<Error> validation = entityService.validateCrmCityMaster(req);
		//// validation
		if (validation != null && validation.size() != 0) {
			data.setCommonResponse(null);
			data.setIsError(true);
			data.setErrorMessage(validation);
			data.setMessage("Failed");
			return new ResponseEntity<CommonCrmRes>(data, HttpStatus.OK);


		} else {
			/////// save

			CrmLeadSuccessRes res = entityService.saveCrmCityMaster(req);
			data.setCommonResponse(res);
			data.setIsError(false);
			data.setErrorMessage(Collections.emptyList());
			data.setMessage("Success");
			if (res != null) {
				return new ResponseEntity<CommonCrmRes>(data, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		}
	}
}

	
	
	

