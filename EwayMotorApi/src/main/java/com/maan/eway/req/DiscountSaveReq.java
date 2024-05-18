package com.maan.eway.req;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class DiscountSaveReq {

	 	@JsonProperty("DiscountId") 
	    private String discountId;
	    @JsonProperty("DiscountDesc") 
	    private String discountDesc;
	    @JsonProperty("DiscountRate") 
	    private String discountRate;
	    @JsonProperty("DiscountAmount") 
	    private Double discountAmount;
	    @JsonProperty("DiscountCalcType") 
	    private String discountCalcType;
	    @JsonProperty("DiscountForId") 
	    private String discountforId;
	    @JsonProperty("SubCoverId") 
	    public String subCoverId;
	    @JsonProperty("MaxDiscountAmount") 
	    public Double maxAmount;
	    @JsonProperty("FactorTypeId")
	    private String factorTypeId;
}
