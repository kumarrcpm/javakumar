package com.maan.eway.common.res;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductEmployeeGetRes {

	@JsonProperty("RequestReferenceNo")
    private String     requestReferenceNo ;
	
	@JsonProperty("RiskId")
    private String    riskId   ;
	
	@JsonProperty("QuoteNo")
    private String  quoteNo;
	
	@JsonProperty("Createdby")
    private String     createdBy    ;
	
	@JsonProperty("InsuranceId")
    private String     insuranceId;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty("EntryDate")
    private Date entryDate;
	
	@JsonProperty("EmployeeId")
    private String    employeeId ;
	
	@JsonProperty("EmployeeName")
    private String    employeeName  ;
	
	@JsonProperty("OccupationId")
    private String     occupationId ;
	
	@JsonProperty("OccupationDesc")
    private String     occupationDesc ;
	
	@JsonProperty("Salary")
    private String salary;
	
	@JsonProperty("ProductId")
    private String    productId   ;
	
	@JsonProperty("ProductDesc")
    private String    productDesc ;
	
	@JsonProperty("NationalityId")
    private String    nationalityId   ;
	
	@JsonProperty("DateOfJoiningYear")
    private String     dateOfJoiningYear ;

	@JsonProperty("DateOfJoiningMonth")
    private String     dateOfJoiningMonth;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@JsonProperty("DateOfBirth")
    private Date dateOfBirth;
	
}
