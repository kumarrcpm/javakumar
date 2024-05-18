package com.maan.travel.req;

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
	@JsonProperty("TravelStartDate")
    private String    travelStartDate  ;
	@JsonProperty("TravelEndDate")
    private String     travelEndDate   ;
	@JsonProperty("AgeFrom")
    private String     ageFrom   ;
	@JsonProperty("AgeTo")
    private String     ageTo   ;
	@JsonProperty("AgencyCode")
    private String     agencyCode   ;
	
	
}
