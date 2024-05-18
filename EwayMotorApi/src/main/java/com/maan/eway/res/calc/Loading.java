package com.maan.eway.res.calc;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Loading implements Serializable {
	 	@JsonProperty("LoadingId") 
	    private String loadingId;
	    @JsonProperty("LoadingDesc") 
	    private String loadingDesc;
	    @JsonProperty("LoadingRate") 
	    private String loadingRate;
	    @JsonProperty("LoadingAmount") 
	    private BigDecimal loadingAmount;
	    @JsonProperty("LoadingCalcType") 
	    private String loadingCalcType;
	    @JsonProperty("LoadingForId") 
	    private String loadingforId;
	    @JsonProperty("SubCoverId") 
	    public String subCoverId;
	    @JsonProperty("MaxLoadingAmount") 
	    public BigDecimal maxAmount;
	    @JsonProperty("FactorTypeId")
	    private String factorTypeId;
}
