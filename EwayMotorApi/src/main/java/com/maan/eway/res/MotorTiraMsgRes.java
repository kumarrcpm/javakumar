package com.maan.eway.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MotorTiraMsgRes {

	@JsonProperty("MotorVerificationRes")
	private MotorVerificationRes motorVerificationRes ;
	
	@JsonProperty("MsgSignature")
	private String msgSignature ;
	
}
