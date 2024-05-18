package com.maan.eway.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class VerificationHdrRes {

	@JsonProperty("ResponseId")
	private String responseId ;
	
	@JsonProperty("RequestId")
	private String requestId ;
	
	@JsonProperty("ResponseStatusCode")
	private String responseStatusCode ;
	
	@JsonProperty("ResponseStatusDesc")
	private String responseStatusDesc ;
}
