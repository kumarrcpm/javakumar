package com.example.demo.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.req.LoginDetailsSaveReq;
import com.example.demo.res.CommonRes;
import com.example.demo.res.SuccessRes;
import com.example.demo.serviceimpl.LoginDetailsServiceImpl;

@RestController
@RequestMapping("/api")
public class LoginDetailsController {

	@Autowired
	private LoginDetailsServiceImpl service;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}

	@PostMapping("/signup")
	public String signup(@RequestBody LoginDetailsSaveReq req){
	String a =service.signup(req);		
		return a;
	}

	@PostMapping("/getuser")
	public String getuser(@RequestBody LoginDetailsSaveReq req){
	String a =service.getuser(req);		
		return a;
	}

	@GetMapping("/generatetoken")
	public String generateToken(){
	String a =service.generateToken();		
		return a;
	}

	@GetMapping("/privateapi")
	public ResponseEntity<CommonRes> privateapi(@RequestHeader(value = "authorization",defaultValue = "")String auth) throws Exception{
		CommonRes data = new CommonRes();
		SuccessRes res = service.privateapi(auth);
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
}
