package com.maan.eway.common.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maan.eway.common.req.TravelPassValidateReq;
import com.maan.eway.common.res.CommonRes;
import com.maan.eway.req.push.TiraMsgVehiclePush;
import com.maan.eway.tira.service.CollectInfomation;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tira")
@Api(tags = "Tira Integration",description="API's")
public class TiraDetailsController {

	 @Autowired
	 private CollectInfomation collect;
	 
	@PostMapping(value="/push", produces=MediaType.APPLICATION_XML_VALUE)
	@ApiOperation(value="This method is to Save Content Risk")
	public ResponseEntity<CommonRes> pushTira(@RequestBody TravelPassValidateReq req){ //@PathVariable("quoteNo") String quoteNo ){
		TiraMsgVehiclePush collectInfo = collect.collectInfo(req.getQuoteNo());
		CommonRes c=new CommonRes();
		c.setCommonResponse(collectInfo);
		return new ResponseEntity<>(c,HttpStatus.OK);
	}
}
