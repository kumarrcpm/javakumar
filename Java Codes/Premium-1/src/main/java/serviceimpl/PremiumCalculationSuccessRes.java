package serviceimpl;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PremiumCalculationSuccessRes {
	@JsonProperty("Response")
	private String response;
	
	@JsonProperty("CityCode")
	private String citycode;
}