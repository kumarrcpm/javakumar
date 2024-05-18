package com.maan.eway.common.res;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TravelPolicyTypeCoverRes {

	
	@JsonProperty("CoverId")
    private String    coverId ;
	
	@JsonProperty("CoverDesc")
    private String    coverDesc;

	@JsonProperty("SubCoverDetails")
    private List<TravelPolicyTypeSubCoverRes> travelSubCover;

}

