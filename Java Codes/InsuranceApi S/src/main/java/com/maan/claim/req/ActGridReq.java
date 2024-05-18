package com.maan.claim.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ActGridReq {

	@JsonProperty("Limit")
	private String limit ;
	
	@JsonProperty("Offset")
	private String offset ;
	
}
