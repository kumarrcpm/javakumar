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
	
	
	
	@JsonProperty("OneToFourRating")
    private String     oneToFourRating   ;

	@JsonProperty("FiveToSixtyFiveRating")
    private String     fiveToSixtyFiveRating   ;
	
	@JsonProperty("SixtySixtoSeventyRating")
    private String     sixtySixtoSeventyRating   ;
	
	@JsonProperty("SeventytoEightyRating")
    private String     seventytoEightyRating   ;
	
	@JsonProperty("TotalRating")
    private String     totalrating   ;
	
	@JsonProperty("OnePercentFee")
    private String     onePercentFee   ;
	
	@JsonProperty("PointSixFee")
    private String     pointSixFee   ;
	
	
	@JsonProperty("TotalFee")
    private String     totalFee   ;
	
	
	@JsonProperty("Vat28per")
    private String     vat28per   ;
	
	
	@JsonProperty("Vat16per")
    private String     vat16per   ;
	
}
