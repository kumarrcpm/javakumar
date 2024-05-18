package com.maan.eway.common.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EservciePaccSaveRes {

	@JsonProperty("RequestReferenceNo")
	private String requestReferenceNo;
	
	@JsonProperty("CustomerReferenceNo")
	private String customerReferenceNo;
	
	@JsonProperty("RiskId")
	private String riskId;
	
	
	@JsonProperty("Response")
	private String response;
	
	@JsonProperty("ProductId")
	private String productId;

	@JsonProperty("MSRefNo")
	private String msrefno;
	
	 @JsonProperty("CdRefNo")
	 private String cdRefNo;

	@JsonProperty("VdRefNo")
	private String asRefNo;

	@JsonProperty("SectionId")
	private String sectionId;
	
	@JsonProperty("InsuranceId")
	private String companyId;

	@JsonProperty("CreatedBy")
	private String createdBy;
}
