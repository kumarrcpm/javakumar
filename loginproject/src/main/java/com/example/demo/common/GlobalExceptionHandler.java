package com.example.demo.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.res.SuccessRes;

public class GlobalExceptionHandler {

	
	@ExceptionHandler
	public ResponseEntity handleAccessDeniedException(AccessDeniedException e) {
		SuccessRes res = new SuccessRes();
		res.setCode(HttpStatus.UNAUTHORIZED.value());
		
		return ResponseEntity.status(401).body(res);
	}
	
	
}
