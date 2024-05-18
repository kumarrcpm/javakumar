package com.maan.eway.springbatch;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.maan.eway.batch.req.DeleteRecordReq;
import com.maan.eway.batch.req.EditRecordReq;
import com.maan.eway.batch.req.GetRecordsReq;
import com.maan.eway.batch.req.GetUploadTransactionReq;
import com.maan.eway.batch.req.SamplFileDownloadReq;
import com.maan.eway.batch.res.UpdateRecordReq;
import com.maan.eway.res.CommonRes;

@RestController
@RequestMapping("/eway")
public class SpringBatchController {
	
	
	@Autowired
	private SpringBatchService service;
	
	
	@PostMapping(value="/batch/upload", consumes = "multipart/form-data", produces = {"application/json", "application/xml"})
	public EwayUploadRes batchUpload(@RequestParam ("file") MultipartFile file ,@RequestParam("uploadReq") String uploadReq
			,@RequestHeader("Authorization") String token) {
		try {
			EwayUploadReq req =null;
			if(StringUtils.isNotBlank(uploadReq)) {
				ObjectMapper mapper =new ObjectMapper();
				req =mapper.readValue(uploadReq, EwayUploadReq.class);
			}
			return service.batchUpload(file,req,token.replaceAll("Bearer ", "").split(",")[0]);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@PostMapping("/get/transaction/status")
	public CommonRes getTransactionStatus(@RequestBody GetUploadTransactionReq req) {
		return service.getTransactionStatus(req);
	}
	
	@PostMapping("/getUploadTransaction")
	public CommonRes getUploadTransaction(@RequestBody GetUploadTransactionReq req) {
		return service.getUploadTransaction(req);
	}
	
	@PostMapping("/get/recordsByStatus")
	public CommonRes getRecordByStatus(@RequestBody GetRecordsReq req) {
		return service.getRecordByStatus(req);
	}
	
	@PostMapping("/edit/record")
	public CommonRes editRecord(@RequestBody EditRecordReq req) {
		return service.editRecord(req);
	}
	
	@PostMapping("/insert/records")
	public CommonRes insertRecords(@RequestBody GetRecordsReq req,@RequestHeader("Authorization") String Authorization) {
		return service.insertRecords(req,Authorization.replaceAll("Bearer ", "").split(",")[0]);
	}
	
	@PostMapping("/update/records")
	public CommonRes updateRecords(@RequestBody UpdateRecordReq req) {
		return service.updateRecords(req);
	}

	@PostMapping("/delete/records")
	public CommonRes deleteRecords(@RequestBody DeleteRecordReq req) {
		return service.deleteRecords(req);
	}
	
	@PostMapping("/sample/download/")
	public CommonRes sampleDownload(@RequestBody SamplFileDownloadReq req) {
		return service.sampleDownload(req);
	}
	
}
