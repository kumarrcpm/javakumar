package com.maan.eway.common.res;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ContentRiskDetailsRes {

	
	
	@JsonProperty("RiskId")
	private String riskId;
	@JsonProperty("ItemId")
	private String itemId;
	@JsonProperty("ItemDesc")
	private String itemDesc;
	@JsonProperty("ItemValue")
	private String itemValue;
	@JsonProperty("SumInsured")
	private String sumInsured;
	@JsonProperty("SerialNo")
	private String serialNo;
	@JsonProperty("MakeAndModel")
	private String makeAndModel;
	@JsonProperty("PurchaseYear")
	private String purchaseYear;
	@JsonProperty("PurchaseMonth")
	private String purchaseMonth;

	@JsonProperty("ContentRiskDesc")
	private String contentRiskDesc ;
	
	@JsonProperty("SerialNoDesc")
	private String serialNoDesc ;
}
