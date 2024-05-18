package com.maan.eway.batch.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRecordReq {
	
	@JsonProperty("ProductId")
    private String productId;
	
	@JsonProperty("RequestRefNo")
    private String requestRefNo;
	
	@JsonProperty("QuoteNo")
    private String quoteNo;
	
	@JsonProperty("CompanyId")
    private String companyId;
	
	@JsonProperty("RiskId")
    private String riskId;
	
	
	@JsonProperty("NationalityId")
	private String nationalityId;
	
	@JsonProperty("EmployeeName")
	private String employeeName;
	
	@JsonProperty("DateOfJoiningMonth")
	private String DateOfJoiningMonth;
	
	@JsonProperty("DateOfJoiningYear")
	private String DateOfJoiningYear;
	
	@JsonProperty("OccupationDesc")
	private String occupationDesc;
	
	@JsonProperty("OccupationId")
	private String occupationId;
	
	@JsonProperty("Status")
	private String status;
	
	@JsonProperty("ErrorDesc")
	private String errorDesc;

	@JsonProperty("RowNum")
    private String rowNum;
	
	@JsonProperty("Salary")
	private String salary;
	
	@JsonProperty("DateOfBirth")
	private String dateOfBirth;
	
	
	

}
