package com.maan.eway.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginBranchCriteriaRes {

	@JsonProperty("BranchCode")
	private String branchCode ;
	
	@JsonProperty("RegionCode")
	private String regionCode ;
	
	@JsonProperty("InsuranceId")
	private String companyId ;
	@JsonProperty("BranchName")
	private String branchName ;
	
	@JsonProperty("CompanyName")
	private String companyName ;
	
//	@JsonProperty("RegionName")
//	private String regionName ;
	
//	@JsonProperty("CompanyLogo")
//	private String companyLogo ;  
	
	@JsonProperty("CurrencyId")
	private String currencyId;  
	/*
	@JsonProperty("SourceType")
	private String sourceType;  
	
	@JsonProperty("DepartmentCode")
	private String departmentCode;  
	
	@JsonProperty("CustomerCode")
	private String customerCode;  
	*/
}
