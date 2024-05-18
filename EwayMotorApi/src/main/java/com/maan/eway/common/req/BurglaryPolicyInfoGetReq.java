package com.maan.eway.common.req;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class BurglaryPolicyInfoGetReq {
	/*
	@JsonProperty("InsuranceId")
    private String companyId   ;
	@JsonProperty("BranchCode")
    private String branchCode ;
	@JsonProperty("ProductId")
    private String productId   ;
	@JsonProperty("SectionId")
    private String sectionId    ;
	@JsonProperty("RequestReferenceNo")
    private String     requestReferenceNo ;	
	*/
	@JsonProperty("QuoteNo")
    private String  quoteNo;
	@JsonProperty("RiskId")
    private String    riskId   ;
	@JsonProperty("Id")
    private String  id   ;

	
}
