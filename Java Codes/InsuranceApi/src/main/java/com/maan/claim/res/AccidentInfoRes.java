package com.maan.claim.res;

//import java.math.BigDecimal;
//import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
//import com.maan.motor.service.impl.data;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AccidentInfoRes {
	
	@JsonProperty("SurveyName")
	private String     surveyorname ;

	@JsonProperty("CallDate")
	private String       calldate ;
	
	@JsonProperty("CallTime")
	private String     calltime ;
	
	@JsonProperty("LandMark")
    private String landmark ;
	
	@JsonProperty("Location")
	private String location ;
	
	@JsonProperty("LocationCoodinates")
	private String     locationcoordinates ;
	
	@JsonProperty("CityId")
	private String     cityid ;
	
	@JsonProperty("City")
	private String     city ;
	
	@JsonProperty("AccidentDescription")
	private String     accidentdescription ;
	
	@JsonProperty("AmemdId")
	private String     amendid ;
	
	@JsonProperty("EntryDate")
	private String     entrydate ;
	
	@JsonProperty("Status")
	private String     status ;
	
	@JsonProperty("Remark")
	private String  remark ;
	
	
}
