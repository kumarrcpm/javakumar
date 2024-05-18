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
public class AgeTypeReq {

	
	@JsonProperty("OneToFour")
    private String     oneToFour;
	@JsonProperty("FiveToSixtyFive")
    private String    fiveToSixtyFive   ;
	@JsonProperty("SixtySixToSeventy")
    private String    sixtySixToSeventy   ;
	@JsonProperty("SeventyOneToEighty")
    private String    SeventyOneEighty   ;
	
	
}
