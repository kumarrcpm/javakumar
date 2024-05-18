package com.maan.crm.res;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProductMasterGroupRes {

	@JsonProperty("Product")
	private ViewProductRes product ;
	
	@JsonProperty("ProductDetailsList")
	private List<ProductDetailsGroupRes> productDetailsList ;
}
