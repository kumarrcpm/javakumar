package com.maan.eway.common.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DriverDetailsGetReq {

	@JsonProperty("QuoteNo")
	private String quoteNo;
	
}
