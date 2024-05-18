package com.maan.eway.common.service.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CriteriaCustomerRes {
	 	// Customer Info
	    private String   customerReferenceNo ;
	    private String policyHolderTypeid;
		private String idType;
		private String idNumber;
		private Integer age;
		private String clientName;
		private String titleDesc;
		private String policyHolderType;
		private String idTypeDesc;
		private Date dobOrRegDate;
		private String genderDesc;
		private String occupationDesc;
		private String businessTypeDesc;
		private String telephoneNo1;
		private String telephoneNo2;
		private String telephoneNo3;
		private String mobileNo1;
		private String mobileNo2;
		private String mobileNo3;
		private String email1;
		private String email2;
		private String email3;
		private String     vrnGst ;
		
		// Vehicle Info
		private String     companyId ;
		private String     productId ;
		private String     branchCode ;
		
		private String   requestReferenceNo ;
		private String createdBy;
		private String status;
		private String quoteNo;
		private String customerId;
		private Date       entryDate ;
		private Date       updatedDate ;
		private String updatedBy;
   
}
