package com.maan.eway.common.res;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TravelPassHistoryRes {

	 	@JsonProperty("QuoteNo")
	    private String     quoteNo ;
	    
	    @JsonProperty("PassengerId")
	    private String     passengerId;
	    
	    @JsonProperty("RequestReferenceNo")
		 private String     requestReferenceNo ;
	    
	    @JsonProperty("TravelId")
	    private Integer    travelId     ;
		
		@JsonProperty("GenderId")
	    private String    genderId     ;
		@JsonProperty("CustomerReferenceNo")
	    private String     customerReferenceNo ;
		@JsonProperty("InsuranceId")
	    private String     companyId    ;
		@JsonProperty("BranchCode")
	    private String     branchCode   ;
		@JsonProperty("ProductId")
	    private Integer    productId    ;
		@JsonProperty("SectionId")
	    private Integer    sectionId    ;

		@JsonProperty("PassengerName")
	    private String     passengerName ;
		
		@JsonProperty("PassengerFirstName")
	    private String     passengerFirstName ;
		@JsonProperty("PassengerLastName")
	    private String     passengerLastName ;

		
		@JsonFormat(pattern = "dd/MM/yyyy")
		@JsonProperty("Dob")
	    private Date       dob          ;
		@JsonProperty("GenderDesc")
	    private String     genderDesc   ;
		@JsonProperty("Age")
	    private Integer    age          ;
		@JsonProperty("RelationId")
	    private Integer    relationId   ;
		@JsonProperty("RelationDesc")
	    private String     relationDesc ;
		@JsonProperty("Nationality")
	    private String     nationality  ;
		@JsonProperty("NationalityDesc")
	    private String     nationalityDesc  ;
		@JsonProperty("CoverType")
	    private String     coverType    ;
		@JsonProperty("PassportNo")
	    private String     passportNo   ;
		@JsonProperty("CivilId")
	    private String     civilId      ;

		@JsonProperty("LoginId")
	    private String     loginId      ;
		@JsonFormat(pattern = "dd/MM/yyyy")
		@JsonProperty("EntryDate")
	    private Date       entryDate    ;
		@JsonProperty("Status")
	    private String     status       ;

		@JsonProperty("TravelCoverId")
	    private Integer    travelCoverId ;
		@JsonProperty("CompanyName")
	    private String     companyName  ;
		@JsonProperty("ProductName")
	    private String     productName  ;
		@JsonProperty("SectionName")
	    private String     sectionName  ;
		@JsonProperty("Currency")
	    private String     currency     ;
		@JsonProperty("ExchangeRate")
	    private Double     exchangeRate ;
		@JsonProperty("TravelCoverDesc")
	    private String     travelCoverDesc ;
		@JsonProperty("SourceCountry")
	    private String     sourceCountry ;
		@JsonProperty("SourceCountryDesc")
	    private String     sourceCountryDesc ;
		@JsonProperty("DestinationCountry")
	    private String     destinationCountry ;
		@JsonProperty("DestinationCountryDesc")
	    private String     destinationCountryDesc ;
		@JsonProperty("SportsCoverYn")
	    private String     sportsCoverYn ;
		@JsonProperty("TerrorismCoverYn")
	    private String     terrorismCoverYn ;
		@JsonProperty("PlanTypeId")
	    private Integer    planTypeId   ;
		@JsonProperty("PlanTypeDesc")
	    private String     planTypeDesc ;
		@JsonFormat(pattern="dd/MM/yyyy")
		@JsonProperty("TravelStartDate")
	    private Date       travelStartDate ;
		@JsonFormat(pattern="dd/MM/yyyy")
		@JsonProperty("TravelEnddDate")
	    private Date       travelEndDate ;
		@JsonProperty("TravelCoverDuration")
	    private Integer    travelCoverDuration ;
		@JsonProperty("TotalPassengers")
	    private Integer    totalPassengers ;
		@JsonFormat(pattern="dd/MM/yyyy")
		@JsonProperty("EffectiveDate")
	    private Date       effectiveDate ;
		@JsonProperty("CreatedBy")
	    private String     createdBy    ;
		@JsonFormat(pattern="dd/MM/yyyy")
		@JsonProperty("UpdatedDate")
	    private Date       updatedDate  ;
		@JsonProperty("UpdatedBy")
	    private String     updatedBy    ;
		@JsonProperty("Remarks")
	    private String     remarks      ;
		@JsonProperty("HavePromoCode")
	    private String     havepromocode ;
		@JsonProperty("PromoCode")
	    private String     promocode    ;
		@JsonProperty("CovidCoverYn")
	    private String     covidCoverYn ;
		@JsonProperty("AcExecutiveId")
	    private Integer    acExecutiveId ;
		@JsonProperty("ApplicationId")
	    private String     applicationId ;
		@JsonProperty("BrokerCode")
	    private String     brokerCode   ;
		@JsonProperty("SubUserType")
	    private String     subUserType  ;
		@JsonProperty("CustomerId")
	    private String     customerId   ;
		@JsonProperty("AdminLoginId")
	    private String     adminLoginId ;
		@JsonProperty("AdminRemarks")
	    private String     adminRemarks ;
		@JsonProperty("RejectReason")
	    private String     rejectReason ;
		@JsonProperty("ReferalRemarks")
	    private String     referalRemarks ;
		@JsonProperty("BdmCode")
	    private String     bdmCode      ;
		@JsonProperty("SourceType")
	    private String     sourceType   ;
		@JsonProperty("CustomerCode")
	    private String     customerCode ;
		@JsonProperty("BrokerBranchCode")
	    private String     brokerBranchCode ;
		@JsonProperty("BrokerBranchName")
	    private String     brokerBranchName ;
		@JsonProperty("CommissionType")
	    private String     commissionType ;
		@JsonProperty("CommissionTypeDesc")
	    private String     commissionTypeDesc ;


		@JsonProperty("GroupId")
	    private String   groupId;
		@JsonProperty("GroupCount")
	    private String   groupCount;
}
