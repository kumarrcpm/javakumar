package com.maan.eway.common.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TravelPolicyTypeGetReq {
	@JsonProperty("PlanTypeId")
    private String    planTypeId    ;
	@JsonProperty("PolicyTypeId")
    private String policyTypeId    ;
}
