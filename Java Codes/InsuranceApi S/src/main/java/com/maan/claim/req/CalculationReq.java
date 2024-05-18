package com.maan.claim.req;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
@Data
public class CalculationReq {
	
	@JsonProperty("VehicleAge")
	private String vehicleAge;
	
	@JsonProperty("DriverDob")
	private String driverDob;
	
	@JsonProperty("SumInsuredAmount")
	private String sumInsuredAmount;
	
	@JsonProperty("VehicleBodyType")
	private String vehicleBodyType;

}
