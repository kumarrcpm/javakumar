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

import com.maan.eway.common.req.TravelPassDetailsGetAllReq;
import com.maan.eway.common.req.TravelPassDetailsGetReq;
import com.maan.eway.common.req.TravelPassDetailsSaveReq;
import com.maan.eway.common.req.TravelPassValidateReq;
import com.maan.eway.common.res.CommonRes;
import com.maan.eway.common.res.TravelPassDetailsRes;
import com.maan.eway.common.res.TravelPassHistoryRes;
import com.maan.eway.common.service.TravelPassengerDetailsService;
import com.maan.eway.error.Error;
import com.maan.eway.res.SuccessRes;
import com.maan.eway.res.TravelPassCommonRes;
import com.maan.eway.service.PrintReqService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(  tags="Eservice Travel Details : Travel Passenger Details ", description = "API's")
@RequestMapping("/api")
public class TravelPassengerDetailsController {

	@Autowired
	private TravelPassengerDetailsService service;

	@Autowired
	private PrintReqService reqService;

	@PreAuthorize("hasAnyRole('ROLE_APPROVER','ROLE_USER')")
	@PostMapping("/updatepassdetails")
	@ApiOperation("This method is to save  Passenger Details")
	public ResponseEntity<CommonRes> savepassdetails(@RequestBody TravelPassDetailsSaveReq req) {
		reqService.reqPrint(req);
		CommonRes data = new CommonRes();

		List<Error> validation = service.validatepassdetails(req);
		if (validation != null && validation.size() > 0) {

			data.setCommonResponse(null);
			data.setErrorMessage(validation);
			data.setMessage("Failed");
			data.setIsError(true);
			return new ResponseEntity<CommonRes>(data, HttpStatus.OK);
		} else {

			SuccessRes res = service.savepassdetails(req);
			data.setCommonResponse(res);
			data.setErrorMessage(Collections.EMPTY_LIST);
			data.setIsError(false);
			data.setMessage("Success");

			if (res != null) {
				return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		}
	}

	@PreAuthorize("hasAnyRole('ROLE_APPROVER','ROLE_USER')")
	@PostMapping("/getpassdetails")
	@ApiOperation("This method is to Get  Passenger Details")
	public ResponseEntity<CommonRes> getpassdetails (@RequestBody TravelPassDetailsGetReq req){
		reqService.reqPrint(req);
		CommonRes data = new CommonRes();
		
		TravelPassDetailsRes res = service.getpassdetails(req);
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
	@PostMapping("/getallpassdetails")
	@ApiOperation("This method is to Getall  Passenger Details")
	public ResponseEntity<CommonRes> getallpassdetails(@RequestBody TravelPassDetailsGetAllReq req ){
		CommonRes data = new CommonRes();
		List<TravelPassDetailsRes> resList = service.getallpassdetails(req);
		data.setCommonResponse(resList);
		data.setErrorMessage(Collections.emptyList());
		data.setIsError(false);
		data.setMessage("Success");
		if(resList!=null) {
			return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PreAuthorize("hasAnyRole('ROLE_APPROVER','ROLE_USER')")
	@PostMapping("/getallpasshistorydetails")
	@ApiOperation("This method is to Getall  Passenger Details")
	public ResponseEntity<CommonRes> getallpasshistorydetails(@RequestBody TravelPassDetailsGetAllReq req ){
		CommonRes data = new CommonRes();
		List<TravelPassHistoryRes> resList = service.getallpasshistorydetails(req);
		data.setCommonResponse(resList);
		data.setErrorMessage(Collections.emptyList());
		data.setIsError(false);
		data.setMessage("Success");
		if(resList!=null) {
			return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PreAuthorize("hasAnyRole('ROLE_APPROVER','ROLE_USER')")
	@PostMapping("/deletepassdetails")
	@ApiOperation("This method is to Delete  Passenger Details")
	public ResponseEntity<CommonRes> deletepassdetails (@RequestBody TravelPassDetailsGetReq req){
		reqService.reqPrint(req);
		CommonRes data = new CommonRes();
		
		SuccessRes res = service.deletepassdetails(req);
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
	@PostMapping("/validatepassdetails")
	@ApiOperation("This method is to Delete  Passenger Details")
	public ResponseEntity<CommonRes> validatepassdetails (@RequestBody TravelPassValidateReq req){
		reqService.reqPrint(req);
		CommonRes data = new CommonRes();
		
		List<Error> validation = service.validatepassListDetails(req);
		if (validation != null && validation.size() > 0) {

			data.setCommonResponse(null);
			data.setErrorMessage(validation);
			data.setMessage("Failed");
			data.setIsError(true);
			return new ResponseEntity<CommonRes>(data, HttpStatus.OK);
		} else {

			TravelPassCommonRes res = service.getpassdetails(req);
			data.setCommonResponse(res);
			data.setErrorMessage(Collections.EMPTY_LIST);
			data.setIsError(false);
			data.setMessage("Success");

			if (res != null) {
				return new ResponseEntity<CommonRes>(data, HttpStatus.CREATED);
			} else {
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
		}
	}
	
	
	
}
