package com.example.demo.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.req.CargoReq;
import com.example.demo.res.CargoVisionRes;
import com.example.demo.res.CommonRes;
import com.example.demo.service.CargoService;

@RestController
@RequestMapping("/master")
public class CargoController {
	
	@Autowired
	private CargoService entityService;
	
	@PostMapping("/cargo")
	public ResponseEntity<CommonRes> getCargo(CargoReq req) {
		CommonRes data = new CommonRes();

		// Get
		CargoVisionRes res = entityService.getCargo(req);
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
