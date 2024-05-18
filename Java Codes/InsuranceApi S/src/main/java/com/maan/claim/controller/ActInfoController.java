package com.maan.claim.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maan.claim.error.Error;
import com.maan.claim.req.ActEditReq;
import com.maan.claim.req.ActGridReq;
import com.maan.claim.req.ActSaveReq;
import com.maan.claim.req.CalculationReq;
import com.maan.claim.res.ActInfoRes;
import com.maan.claim.res.CalculationRes;
import com.maan.claim.res.CommonResponse;
import com.maan.claim.res.SuccessRes;
import com.maan.claim.service.ActInfoService;
import com.maan.claim.service.CalculationService;
import com.maan.claim.service.PrintReqService;

@ComponentScan
@RestController
@RequestMapping("/api")
public class ActInfoController {

	@Autowired
	private ActInfoService entityService;
	
	@Autowired
	private CalculationService  calcService;

	@Autowired
	private PrintReqService reqPrinter;

	// findall details
	
	@GetMapping("/actdetails")
	public ResponseEntity<List<ActInfoRes>> getActDetails() {

		List<ActInfoRes> data = entityService.getActDetails();
		if (data != null) {
			return new ResponseEntity<>(data, HttpStatus.CREATED);
		} else {
			return null;
			// return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}

	// find by sequence id
	@GetMapping("/act/{sequnceid}")
	public ResponseEntity<ActInfoRes> getActDetails(@PathVariable("sequnceid") String id) {

		ActInfoRes data = entityService.getActInfo(id);
		if (data != null) {
			return new ResponseEntity<>(data, HttpStatus.CREATED);
		} else {
			return null;
			// return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}

	// get details  using sequenceID by post method 
	@PostMapping("/actbyid")
	public ResponseEntity<ActInfoRes> getActDetailsById(@RequestBody ActEditReq req) {

		ActInfoRes data = entityService.getActDetailsById(req);
		if (data != null) {
			return new ResponseEntity<>(data, HttpStatus.CREATED);
		} else {
			return null;
		}
	}
//save single list of data
	@PostMapping("/saveact") 
	public ResponseEntity<SuccessRes> saveActDetails(@RequestBody ActSaveReq req) {

		List<Error> errors = entityService.validateActDetailsReq(req);
		if (errors != null && errors.size() > 0) {
			SuccessRes res = new SuccessRes();
			res.setResponse("Failed");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		SuccessRes data = entityService.saveActDetails(req);
		if (data != null) {
			return new ResponseEntity<>(data, HttpStatus.CREATED);
		} else {
			return null;
		}
	}
//save list of data using common response
	@PostMapping("/common/saveact")
	public ResponseEntity<CommonResponse> saveClaimInfo(@RequestBody ActSaveReq req) {

		reqPrinter.reqPrint("Printer Request --->" + req);
		CommonResponse data = new CommonResponse();

		// Validation
		List<Error> validation = entityService.validateActDetailsReq(req);
		if (validation != null && validation.size() != 0) {

			data.setCommonResponse(null);
			data.setIsError(true);
			data.setErrorMessage(validation);
			data.setMessage("Failed");

			return new ResponseEntity<CommonResponse>(data, HttpStatus.OK);

		} else {
			// Save
			SuccessRes res = entityService.saveActDetails(req);
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
//save many list of data 
	@PostMapping("/saveallact")

	public ResponseEntity<CommonResponse> saveActDetails(@RequestBody List<ActSaveReq> req) {
		reqPrinter.reqPrint("Printer Request --->" + req);
		CommonResponse data = new CommonResponse();

		// Validation
		List<Error> validation = entityService.validateListOfActDetailsReq(req);
		if (validation != null && validation.size() != 0) {

			data.setCommonResponse(null);
			data.setIsError(true);
			data.setErrorMessage(validation);
			data.setMessage("Failed");

			return new ResponseEntity<CommonResponse>(data, HttpStatus.OK);

		} else {
			// Save
			SuccessRes res = entityService.saveListOfActDetails(req);
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

	//get details 2 table
	@PostMapping("/actbyidwithlist")
	public ResponseEntity<ActInfoRes> ByIdWithList(@RequestBody ActEditReq req) {

		ActInfoRes data = entityService.getActDetailsByIdWithList(req);
		if (data != null) {
			return new ResponseEntity<>(data, HttpStatus.CREATED);
		} else {
			return null;
		}
	}

	@PostMapping("/saveactlist")
	public ResponseEntity<SuccessRes> saveActDetailsWithAccidentList(@RequestBody ActSaveReq req) {

		List<Error> errors = entityService.validateActDetailsWithAccidentList(req);
		if (errors != null && errors.size() > 0) {
			SuccessRes res = new SuccessRes();
			res.setResponse("Failed");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		SuccessRes data = entityService.saveActDetailsWithAccidentList(req);
		if (data != null) {
			return new ResponseEntity<>(data, HttpStatus.CREATED);
		} else {
			return null;
		}
	}

	/*
	 * Table record = 100 etry date desc = 100,99,98 ,
	 * 
	 * (i) limit = 0 offset = 10 output = 100 - 91
	 * 
	 * (i) limit = 1 offset = 20 output = 90 - 71
	 */
	// findall details with Pagination
	@PostMapping("/actdetails2")
	public ResponseEntity<List<ActInfoRes>> getActDetails2(@RequestBody ActGridReq req) {

		List<ActInfoRes> data = entityService.getActDetails2(req);
		if (data != null) {
			return new ResponseEntity<>(data, HttpStatus.CREATED);
		} else {
			return null;
			// return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}

//******************************SIMPLE_CALCULATION***************************
	/*@PostMapping("/vehiclecalc")
	public ResponseEntity<CalculationRes> calulatePremium(@RequestBody CalculationReq req) {

		CalculationRes data = calc.getCalculation(req);
		if (data != null) {
			return new ResponseEntity<>(data, HttpStatus.CREATED);
		} else {
			return null;
		}
		*/
	
	
 @PostMapping("/vehiclecalc")
	public ResponseEntity<CalculationRes> calulatePremium(@RequestBody CalculationReq req) {

	/*	List<Error> errors = calcService.validateReq(req);
		if (errors != null && errors.size() > 0) {
			SuccessRes res = new SuccessRes();
			res.setResponse("Failed");
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} */

		CalculationRes data =calcService.getCalculation(req);
		if (data != null) {
			return new ResponseEntity<>(data, HttpStatus.CREATED);
		} else {
			return null;

		}	

}
 /*	
	// (i) Existing Quote
	@PostMapping("/existingquote")
	public ResponseEntity<CommonResponse> getAllExistingQuote(@RequestBody ExistingQuoteGridReq req) {
		reqPrinter.reqPrint(req);
		CommonResponse data = new CommonResponse();

		// Get All
		List<ExistingQuoteGridRes> res = entityService.getAllExistingQuote(req);
		data.setCommonResponse(res);
		data.setIsError(false);
		data.setErrorMessage(Collections.emptyList());
		data.setMessage("Success");

		if (res != null) {
			return new ResponseEntity<CommonResponse>(data, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
		
	}*/
}
