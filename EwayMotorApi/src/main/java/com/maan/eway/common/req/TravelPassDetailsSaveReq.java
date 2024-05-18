package com.maan.eway.common.req;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TravelPassDetailsSaveReq {

	@JsonProperty("QuoteNo")
	private String quoteNo;
	
	@JsonProperty("PassengerId")
	private String passengerId;
	
	@JsonProperty("PassengerFirstName")
	private String passengerFirstName;
	
	@JsonProperty("PassengerLastName")
	private String passengerLastName;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@JsonProperty("Dob")
	private Date dob;
	
	@JsonProperty("GenderId")
	private String genderId;
	
	@JsonProperty("Age")
	private String age;

	@JsonProperty("RelationId")
	private String relationId;

//	@JsonProperty("NameTitleId")
//	private String nameTitleId;

	@JsonProperty("CreatedBy")
	private String createdBy;
	
	@JsonProperty("Natinality")
	private String nationality;
	
//	@JsonProperty("StateCode")
//	private String stateCode;
//	
	
//	@JsonProperty("CoverType")
//	private String coverType;
	
	@JsonProperty("PassportNo")
	private String passportNo;
	
	@JsonProperty("CivilId")
	private String civilId;
//	
//	@JsonProperty("BasePremium")
//	private String basePremium;
//	
//	
//	@JsonProperty("SportsPremium")
//	private String sportsPremium;
	
//	@JsonProperty("TerrorismPremium")
//	private String terrorismPremium;
//
//	@JsonProperty("TotalPremium")
//	private String totalPremium;
//
//	@JsonProperty("LoginId")
//	private String loginId;
//
//	@JsonProperty("Address1")
//	private String address1;
//
//	@JsonProperty("Address2")
//	private String address2;
//
//	@JsonProperty("City")
//	private String city;
//
//	@JsonProperty("PoBox")
//	private String pobox;
//
//	@JsonProperty("PromoPremium")
//	private String promoPremium;
//
//	@JsonProperty("CovidPremium")
//	private String covidPremium;

}
