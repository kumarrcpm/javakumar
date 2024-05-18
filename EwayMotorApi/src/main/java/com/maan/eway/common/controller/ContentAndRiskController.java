package com.maan.eway.common.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maan.eway.common.req.ContentAndRiskSaveReq;
import com.maan.eway.common.req.ContentRiskGetAllReq;
import com.maan.eway.common.req.ContentRiskGetReq;
import com.maan.eway.common.res.CommonRes;
import com.maan.eway.common.res.ContentRiskGetRes;
import com.maan.eway.common.res.ContentRiskGetallRes;
import com.maan.eway.common.service.ContentAndRiskService;
import com.maan.eway.error.Error;
import com.maan.eway.res.SuccessRes;
import com.maan.eway.service.PrintReqService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags = "CONTENT AND RISK",description="API's")
public class ContentAndRiskController {

	@Autowired
	private ContentAndRiskService service;
	
	@Autowired
	private PrintReqService reqPrinter;
	
	
	@PreAuthorize("hasAnyRole('ROLE_APPROVER','ROLE_USER')")
	@PostMapping(value="/savecontentrisk")
	@ApiOperation(value="This method is to Save Content Risk")
	public ResponseEntity<CommonRes> savecontentrisk(@RequestBody ContentAndRiskSaveReq req){
		reqPrinter.reqPrint(req);
		CommonRes data = new CommonRes();
		List<Error> validation =  service.validatecontentrisk(req);
		//Validation
		if(validation!=null && validation.size()!=0) {
			data.setCommonResponse(null);
			data.setIsError(true);
			data.setErrorMessage(validation);
			data.setMessage("Failed");
			return new ResponseEntity<CommonRes>(data, HttpStatus.OK);
		}
		else {
			SuccessRes res = service.savecontentrisk(req);
			data.setCommonResponse(res);
			data.setIsError(false);
			data.setErrorMessage(Collections.emptyList());
			data.setMessage("Success");
			if(res !=null) {
				return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		}
		
	}

	@PreAuthorize("hasAnyRole('ROLE_APPROVER','ROLE_USER')")
	@PostMapping(value="/getcontentrisk")
	@ApiOperation(value="This method is to Get get Content Risk")
	public ResponseEntity<CommonRes> getcontentrisk(@RequestBody ContentRiskGetReq req){
		reqPrinter.reqPrint(req);
		CommonRes data = new CommonRes();
		ContentRiskGetRes  res = service.getcontentrisk(req);
		data.setCommonResponse(res);
		data.setIsError(false);
		data.setErrorMessage(Collections.emptyList());
		data.setMessage("Success");
		if(res !=null) {
			return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	

	@PreAuthorize("hasAnyRole('ROLE_APPROVER','ROLE_USER')")
	@PostMapping(value="/getallcontentrisk")
	@ApiOperation(value="This method is to Getall Content Risk")
	public ResponseEntity<CommonRes> getallcontentrisk(@RequestBody ContentRiskGetAllReq req){
		reqPrinter.reqPrint(req);
		CommonRes data = new CommonRes();
		ContentRiskGetallRes  res = service.getallcontentrisk(req);
		data.setCommonResponse(res);
		data.setIsError(false);
		data.setErrorMessage(Collections.emptyList());
		data.setMessage("Success");
		if(res !=null) {
			return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	
	
}
