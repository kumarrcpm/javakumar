package com.maan.eway.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MotorSaveRes {

	@JsonProperty("Response")
	private String response;

	@JsonProperty("ShowVehicleInfo")
	private MotorVehicleInfoRes showVehicleInfo;
}
