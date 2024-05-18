package com.maan.eway.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.maan.eway.req.TiraMsg;
import com.maan.eway.req.push.TiraMsgVehiclePush;
import com.maan.eway.res.CommonRes;
import com.maan.eway.res.MotorTiraMsgRes;
import com.maan.eway.service.ExternalApiCallService;
import com.maan.eway.service.PrintReqService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "External : Details ", description = "API's")
@RequestMapping("/dispatch/api")
public class ExternalApiCallController {

	@Autowired
	private ExternalApiCallService externalService ;
	
	@Autowired
	private PrintReqService  reqPrinter ;
	
	@PreAuthorize("hasAnyRole('ROLE_APPROVER','ROLE_USER')")
	@PostMapping("/motor/verification/v1/request")
	@ApiOperation(value = "This method is to insert Customer")
	public ResponseEntity<CommonRes> savecustomer(@RequestBody TiraMsg req){
		CommonRes data = new CommonRes();
		reqPrinter.reqPrint(req);
		
		MotorTiraMsgRes res = externalService.getSampleData(req);
		data.setCommonResponse(res);
		data.setErrorMessage(Collections.emptyList());
		data.setIsError(false);
		data.setMessage("Success");
		
		if(res!=null) {
			return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	} 
	
	@PreAuthorize("hasAnyRole('ROLE_APPROVER','ROLE_USER')")
	@PostMapping("/covernote/non-life/motor/v2/request")
	@ApiOperation(value = "This method is Push Policy Information")
	@JsonDeserialize //(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
	public ResponseEntity<CommonRes> pushVehicleInfo(@RequestBody TiraMsgVehiclePush req)throws Exception {
		externalService.pushVehicleInfo(req);
		return null;
	}
	 
	@PreAuthorize("hasAnyRole('ROLE_APPROVER','ROLE_USER')")
	@PostMapping("/covernote/non-life/motor/v2/acknowledge")
	@ApiOperation(value = "This method is Push Policy Information")
	public ResponseEntity<CommonRes> pushedVehicleAcknowledge(@RequestBody Object req){
		System.out.println("Response:"+req.toString());
		return null;
	}
	
}
