package com.maan.eway.springbatch;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EwayBatchReq {
	
	@JsonProperty("EwayUploadRes")
	private EwayUploadRes ewayUploadRes;
}
