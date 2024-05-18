package com.maan.eway.common.req;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ContentRiskDetailsListReq {

	
	@JsonProperty("ItemId")
	private String itemId;
	@JsonProperty("ItemValue")
	private String itemValue;
	@JsonProperty("SumInsured")
	private String sumInsured;
	@JsonProperty("SerialNo")
	private String serialNo;
	@JsonProperty("MakeAndModel")
	private String makeAndModel;
	@JsonProperty("RiskId")
	private String riskId;
	@JsonProperty("PurchaseYear")
	private String purchaseYear;
	@JsonProperty("PurchaseMonth")
	private String purchaseMonth;
	
	@JsonProperty("ContentRiskDesc")
	private String contentRiskDesc ;
	
	@JsonProperty("SerialNoDesc")
	private String serialNoDesc ;
	
	}
