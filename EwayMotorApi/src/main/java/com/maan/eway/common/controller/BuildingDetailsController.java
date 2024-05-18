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

import com.maan.eway.common.req.BuildingDetailsGetAllReq;
import com.maan.eway.common.req.BuildingDetailsGetReq;
import com.maan.eway.common.req.BuildingDetailsSaveReq;
import com.maan.eway.common.res.BuildingDetailsGetRes;
import com.maan.eway.common.res.CommonRes;
import com.maan.eway.common.service.BuildingDetailsService;
import com.maan.eway.error.Error;
import com.maan.eway.res.SuccessRes;
import com.maan.eway.service.PrintReqService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(tags = "BUILDING DETAILS",description="API's")
public class BuildingDetailsController {

	@Autowired
	private BuildingDetailsService service;
	
	@Autowired
	private PrintReqService reqPrinter;
	
	
	@PreAuthorize("hasAnyRole('ROLE_APPROVER','ROLE_USER')")
	@PostMapping("/buildingdetails")
	@ApiOperation(value="This method is to Save Building Details")
	public ResponseEntity<CommonRes> savebuildingDetails(@RequestBody List<BuildingDetailsSaveReq> req){
		reqPrinter.reqPrint(req);
		CommonRes data = new CommonRes();
		List<Error> validation =  service.validatebuildingDetails(req);
		//Validation
		if(validation!=null && validation.size()!=0) {
			data.setCommonResponse(null);
			data.setIsError(true);
			data.setErrorMessage(validation);
			data.setMessage("Failed");
			return new ResponseEntity<CommonRes>(data, HttpStatus.OK);
		}
		else {
			SuccessRes res = service.savebuildingDetails(req);
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
	@PostMapping("/getbuildingdetails")
	@ApiOperation(value="This method is to Get Building Details")
	public ResponseEntity<CommonRes> getbuildingDetails(@RequestBody BuildingDetailsGetReq req){
		reqPrinter.reqPrint(req);
		CommonRes data = new CommonRes();
		BuildingDetailsGetRes  res = service.getbuildingDetails(req);
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
	@PostMapping("/getallbuildingdetails")
	@ApiOperation(value="This method is to Getall Building Details")
	public ResponseEntity<CommonRes> getallbuildingDetails(@RequestBody BuildingDetailsGetAllReq req){
		reqPrinter.reqPrint(req);
		CommonRes data = new CommonRes();

		
		List<BuildingDetailsGetRes>  res = service.getallbuildingDetails(req);
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
	
	
	@PostMapping("/deletebuildingdetails")
	@ApiOperation(value="This method is to Getall Building Details")
	public ResponseEntity<CommonRes> deletebuildingDetails(@RequestBody BuildingDetailsGetReq req){
		reqPrinter.reqPrint(req);
		CommonRes data = new CommonRes();

		
		SuccessRes res = service.deleteBuildingDetails(req);
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
