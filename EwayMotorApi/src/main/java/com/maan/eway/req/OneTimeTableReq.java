package com.maan.eway.req;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.maan.eway.bean.EserviceBuildingDetails;
import com.maan.eway.bean.EserviceMotorDetails;
import com.maan.eway.bean.MsCommonDetailsId;
import com.maan.eway.common.req.TravelGroupInsertReq;
import com.maan.eway.common.res.BuildingSectionRes;

import lombok.Data;

@Data

public class OneTimeTableReq {

	@JsonProperty("RequestReferenceNo")
	private String requestReferenceNo ;
	
	@JsonProperty("VehicleId")
	 private Integer    vehicleId ;
	
	@JsonProperty("Id")
	 private Integer    id ;
	
	@JsonProperty("MotorDetails")
	private EserviceMotorDetails motorDetails ;
	
	
	@JsonProperty("AgencyCode")
	private String agencyCode ;
	@JsonProperty("BranchCode")
	private String branchCode ;
	@JsonProperty("InsuranceId")
	private String insuranceId ;
	@JsonProperty("ProductId")
	private Integer productId ;
	@JsonProperty("SectionId")
	private Integer sectionId ; 
	
	@JsonProperty("SectionIds")
	private List<String> sectionIds ; 
	
	@JsonProperty("GroupDetails")
	private List<TravelGroupInsertReq> groupDetails;
	
	@JsonProperty("SectionList")
	private List<BuildingSectionRes> sectionList ;
	
	
	
	
}
