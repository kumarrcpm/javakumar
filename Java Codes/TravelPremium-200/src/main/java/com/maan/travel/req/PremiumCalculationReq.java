package com.maan.travel.req;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PremiumCalculationReq {

	
	@JsonProperty("TypeId")
    private String     typeId   ;
	@JsonProperty("CoverId")
    private String     coverId   ;
	@JsonProperty("TravelledDays")
    private String   travelledDays  ;
	@JsonProperty("AgencyCode")
    private String     agencyCode   ;
	
	@JsonProperty("AgeDetails")
	private AgeTypeReq ageDetails;
}
