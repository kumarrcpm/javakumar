package com.maan.eway.common.req;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductEmployeeSaveReq {


	@JsonProperty("RequestReferenceNo")
    private String     requestReferenceNo ;
	
	@JsonProperty("InsuranceId")
    private String     insuranceId;
	
	@JsonProperty("ProductId")
    private String     productId;
	
	@JsonProperty("QuoteNo")
    private String  quoteNo;
	
	@JsonProperty("Createdby")
    private String     createdBy    ;

	@JsonProperty("RiskId")
    private String     riskId ;
	
	@JsonProperty("EmployeeId")
    private String    employeeId ;
	
	@JsonProperty("EmployeeName")
    private String    employeeName  ;
	
	@JsonProperty("NationalityId")
    private String    nationalityId;
	
	@JsonProperty("OccupationId")
    private String     occupationId ;
	
	@JsonProperty("OccupationDesc")
    private String     occupationDesc ;
	
	@JsonProperty("Salary")
    private String salary;
	
	@JsonProperty("DateOfJoiningYear")
    private String     dateOfJoiningYear ;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty("DateOfBirth")
    private Date dateOfBirth;

	@JsonProperty("DateOfJoiningMonth")
    private String     dateOfJoiningMonth;

}
