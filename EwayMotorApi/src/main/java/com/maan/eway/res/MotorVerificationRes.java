package com.maan.eway.res;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maan.eway.req.VerificationDetailsReq;

import lombok.Data;

@Data
public class MotorVerificationRes {

	@JsonProperty("VerificationHdr")
	private VerificationHdrRes verificationHdr ;
	
	@JsonProperty("VerificationDtl")
	private VerificationHdrDtlsRes VerificationDtl ;
}
