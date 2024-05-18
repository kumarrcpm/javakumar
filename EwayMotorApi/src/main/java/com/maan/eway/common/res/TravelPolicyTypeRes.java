package com.maan.eway.common.res;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TravelPolicyTypeRes {

	
	@JsonProperty("PolicyTypeId")
    private String  policyTypeId  ;

	@JsonProperty("PolicyTypeDesc")
    private String  policyTypeDesc ;
	
	@JsonProperty("PlanTypeId")
    private String  planTypeId  ;

	@JsonProperty("PlanTypeDesc")
    private String  planTypeDesc ;

	@JsonProperty("CoverDetails")
    private List<TravelPolicyTypeCoverRes> travelCover ;

}

