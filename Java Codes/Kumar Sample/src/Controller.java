
public class Controller {
	/*
	*  Copyright (c) 2019. All right reserved
	* Created on 2022-04-19 ( Date ISO 2022-04-19 - Time 19:43:26 )
	* Generated by Telosys Tools Generator ( version 3.3.0 )
	*/
	package com.maan.motor.controller;

	import com.maan.motor.auth.dto.resp.SuccessRes;
	import com.maan.motor.bean.ActInfo;
	import com.maan.motor.error.Error;
	import com.maan.motor.req.ActInfoSaveReq;
	import com.maan.motor.res.ActInfoMasterGetRes;
	import com.maan.motor.res.CommonResponse;
	import com.maan.motor.service.ActInfoService;
	import com.maan.motor.service.PrintReqService;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import java.util.Collections;
	import java.util.List;


	/**
	* <h2>ActInfoController</h2>
	*/
	@RestController
	@RequestMapping("/api")
	public class ActInfoController {

		@Autowired
		private  ActInfoService entityService;
		
		@Autowired
		private  PrintReqService reqPrinter;


	/*
		private static final String ENTITY_TITLE = "ActInfo";


	 	public ActInfoController (ActInfoService entityService) {
			this.entityService = entityService;
		}
	*/

		@PostMapping(value = "/actinfo")
		public ResponseEntity<ActInfo> createActInfo(@RequestBody  ActInfo model) {

	   		 ActInfo data = entityService.create(model);
	    		if (data != null) {
	    			return new ResponseEntity<>(data,HttpStatus.CREATED);
	  			  } else {
	    			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
	   			 }
	    }

	      
		@PostMapping(value = "/saveactinfo")
		public ResponseEntity<CommonResponse> saveActInfo(@RequestBody ActInfoSaveReq req) {
			// PrintReqService reqPrinter = null;
			reqPrinter.reqPrint(req);
			CommonResponse data = new CommonResponse();
			List<Error> validation = entityService.validateActInfo(req);
			if (validation != null && validation.size() != 0) {
				data.setCommonResponse(null);
				data.setIsError(true);
				data.setErrorMessage(validation);
				data.setMessage("Failed");
				return new ResponseEntity<CommonResponse>(data, HttpStatus.OK);
			} else {
				// Save
				SuccessRes res = entityService.saveActInfo(req);
				data.setCommonResponse(res);
				data.setIsError(false);
				data.setErrorMessage(Collections.emptyList());
				data.setMessage("Success");
				if (res != null) {
					return new ResponseEntity<CommonResponse>(data, HttpStatus.CREATED);
				} else {
					return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				}
			}
		}
		@GetMapping(value = "/getallactinfocontroller")
	    public ResponseEntity<CommonResponse> getAllActInfo() {
	    	CommonResponse data = new CommonResponse()  ; 
	    	
	    	// Get All
			List<ActInfoMasterGetRes> res = entityService.getAllActInfoMaster();
			data .setCommonResponse(res);
			data.setIsError(false);
			data.setErrorMessage(Collections.emptyList());
			data.setMessage("Success");
			if (res != null) {
			return new ResponseEntity<CommonResponse>(data, HttpStatus.CREATED);
			} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			}
	    }


		public SuccessRes getSequencenumber() {
			// TODO Auto-generated method stub
			return null;
		}

	    }
	    
	/*
	        @GetMapping(value = "/actinfo/{id}")
	    public ResponseEntity<ActInfo> getOneActInfo(@PathVariable("id") long id) {

	            ActInfo e = entityService.getOne(id);
	            if (e == null) {
	            	return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	            }
	            return new ResponseEntity<>(e, HttpStatus.OK);
	    }

	*/



}