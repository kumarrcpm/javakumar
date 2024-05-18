package com.maan.travel.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PremiumCalculationRes {
	
	
	@JsonProperty("Rating")
    private String     rating   ;
}
