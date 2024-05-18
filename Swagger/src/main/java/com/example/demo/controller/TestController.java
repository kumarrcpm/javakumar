package com.example.demo.controller;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.req.EmployeeDeptReq;
import com.example.demo.req.EmployeeSaveReq;
import com.example.demo.res.EmployeeDeptRes;
import com.example.demo.service.impl.TestServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class TestController {

	@Autowired
	private TestServiceImpl testServiceImpl;
	
	@GetMapping("/employee")
	//public ResponseEntity<List<EmployeeDeptRes>> getemployee(){
		//List<EmployeeDeptRes> res = testServiceImpl.getemployeeDept();
	//return new ResponseEntity<>(res,HttpStatus.OK); 		
	
	
	public ResponseEntity<EmployeeDeptRes> getemployee(){			
	EmployeeDeptRes res = testServiceImpl.getemployeeDept();
		return new ResponseEntity<>(res,HttpStatus.OK); 		
		
		
	}
	@Validated
	@PostMapping("/addEmployee")
	public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeeSaveReq employeeSaveReq){
		try {
		if(!employeeSaveReq.getEmployeeId().isBlank()) {
		System.out.println(employeeSaveReq.getEmployeeId());
		}
		System.out.println(employeeSaveReq.getEmployeeName());
		System.out.println(employeeSaveReq.getJoiningDate());
		}
		catch(Exception e) {
		e.printStackTrace();
		}return null;
		
	}
	
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	    @ResponseStatus(HttpStatus.BAD_REQUEST)
	    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
	        return ResponseEntity.badRequest().body(ex.getBindingResult().getFieldError().getDefaultMessage());
	    }
}

