package com.maan.eway.batch.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetRecordsRes {
	
	@JsonProperty("CompanyId")
    private String companyId;
	
	@JsonProperty("ProductId")
    private String productId;
	
	@JsonProperty("RequestRefNo")
    private String requestRefNo;
	
	@JsonProperty("SectionId")
    private String sectionId;
	
	@JsonProperty("VehicleId")
    private String vehicleId;
	
	@JsonProperty("SearchByData")
    private String searchByData;

	@JsonProperty("InsuranceType")
    private String insuranceType;
	
	@JsonProperty("BodyType")
    private String bodyType;
	
	@JsonProperty("InsuranceClass")
    private String insuranceClass;
	
	@JsonProperty("ErrorDesc")
    private String erroDesc;
	
	@JsonProperty("Status")
    private String status;
	
	@JsonProperty("RowNum")
    private String rowNum;
	
	@JsonProperty("PolicyStartDate")
    private String policyStartDate;
	
	@JsonProperty("PolicyEndDate")
    private String policyEndDate;


}
