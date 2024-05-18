package com.maan.crm.notification.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maan.crm.notification.mail.dto.MailTriggerReq;
import com.maan.crm.notification.mail.dto.ReadMailReq;
import com.maan.crm.notification.mail.dto.ReadMailRes;
import com.maan.crm.notification.service.NotificationService;
import com.maan.crm.res.CommonCrmRes;
import com.maan.crm.res.SuccessRes;
import com.maan.crm.service.PrintReqService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "NOTIFIACTION : Notifiaction ", description = "API's")
@RequestMapping("/post/notification")
public class NotificationController {

	@Autowired
	private NotificationService mailservice;
	
	@Autowired
	private PrintReqService reqPrinter;

	@PostMapping("/readMail")
	@ApiOperation(value = "This method is to Read Email")
	public ResponseEntity<CommonCrmRes> readMails(@RequestBody ReadMailReq req) {


		reqPrinter.reqPrint("Printer Request --->" + req);
		
		CommonCrmRes data = new CommonCrmRes();
		
		List<ReadMailRes> res = mailservice.ReadMail(req);

		if (res.size()!=0) {
			
			data.setCommonResponse(res);
			data.setIsError(false);
			data.setErrorMessage(Collections.emptyList());
			data.setMessage("Success");
			
			return new ResponseEntity<CommonCrmRes>(data, HttpStatus.CREATED);
		} else {
			
			data.setCommonResponse(res);
			data.setIsError(false);
			data.setErrorMessage(Collections.emptyList());
			data.setMessage("No Recieved Mail for last 10 Days");
			return new ResponseEntity<CommonCrmRes>(data, HttpStatus.CREATED);
		}
		
	}

	@PostMapping("/sendMail")
	@ApiOperation(value = "This method is to Send Email")
	public ResponseEntity<CommonCrmRes> sendMails(@RequestBody MailTriggerReq req) {
		
		reqPrinter.reqPrint("Printer Request --->" + req);
		
		CommonCrmRes data = new CommonCrmRes();
		
		SuccessRes res = mailservice.SendMail(req);

		data.setCommonResponse(res);
		data.setIsError(false);
		data.setErrorMessage(Collections.emptyList());
		data.setMessage("Success");
		if (res != null) {
			return new ResponseEntity<CommonCrmRes>(data, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
