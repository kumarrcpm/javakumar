package com.maan.claim.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CalculationRes {

	/*@JsonProperty("Total")
	private float total;
	*/
	@JsonProperty("TotalPremium")
	private float totalPremium;
	
	
}
