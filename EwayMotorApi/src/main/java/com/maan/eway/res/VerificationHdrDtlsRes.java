package com.maan.eway.res;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class VerificationHdrDtlsRes {

	@JsonProperty("MotorCategory")
	private String motorCategory ;
	
	@JsonProperty("RegistrationNumber")
	private String registrationNumber ;
	
	@JsonProperty("ChassisNumber")
	private String chassisNumber ;
	
	@JsonProperty("Make")
	private String make ;
	
	@JsonProperty("Model")
	private String model ;
	
	@JsonProperty("ModelNumber")
	private String modelNumber ;
	
	@JsonProperty("BodyType")
	private String bodyType ;
	
	@JsonProperty("Color")
	private String color ;
	
	@JsonProperty("EngineNumber")
	private String engineNumber ;
	
	@JsonProperty("EngineCapacity")
	private String engineCapacity ;
	
	@JsonProperty("FuelUsed")
	private String fuelUsed ;
	
	@JsonProperty("NumberOfAxles")
	private String numberOfAxles ;
	
	@JsonProperty("AxleDistance")
	private String axleDistance ;
	
	@JsonProperty("SittingCapacity")
	private String sittingCapacity ;
	
	@JsonProperty("YearOfManufacture")
	private String yearOfManufacture ;
	
	@JsonProperty("TareWeight")
	private String tareWeight ;
	
	@JsonProperty("GrossWeight")
	private String grossWeight ;
	
	@JsonProperty("MotorUsage")
	private String motorUsage ;
	
	@JsonProperty("OwnerName")
	private String ownerName ;
	
	@JsonProperty("OwnerCategory")
	private String ownerCategory ;

}
