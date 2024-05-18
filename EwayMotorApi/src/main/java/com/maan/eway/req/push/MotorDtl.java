package com.maan.eway.req.push;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
@Data
//@XmlRootElement(name="MotorDtl")
@ToString
@Jacksonized
@XmlAccessorType(XmlAccessType.FIELD)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MotorDtl {
 
	@JsonProperty("AxleDistance")
	@XmlElement(name = "AxleDistance")
    String axleDistance;
	@JsonProperty("BodyType")
	@XmlElement(name = "BodyType")
    String bodyType;
	@JsonProperty("ChassisNumber")
	@XmlElement(name = "ChassisNumber")
    String chassisNumber;
	@JsonProperty("Color")
	@XmlElement(name = "Color")
    String color;
	@JsonProperty("EngineCapacity")
	@XmlElement(name = "EngineCapacity")
    String engineCapacity;
	@JsonProperty("EngineNumber")
	@XmlElement(name = "EngineNumber")
    String engineNumber;
	@JsonProperty("FuelUsed")
	@XmlElement(name = "FuelUsed")
    String fuelUsed;
	@JsonProperty("GrossWeight")
	@XmlElement(name = "GrossWeight")
    String grossWeight;
	@JsonProperty("Make")
	@XmlElement(name = "Make")
    String make;
	@JsonProperty("Model")
	@XmlElement(name = "Model")
    String model;
	@JsonProperty("ModelNumber")
	@XmlElement(name = "ModelNumber")
    String modelNumber;
	@JsonProperty("MotorCategory")
	@XmlElement(name = "MotorCategory")
    String motorCategory;
	@JsonProperty("MotorType")
	@XmlElement(name = "MotorType")
    String motorType;
	@JsonProperty("MotorUsage")
	@XmlElement(name = "MotorUsage")
    String motorUsage;
	@JsonProperty("NumberOfAxles")
	@XmlElement(name = "NumberOfAxles")
    String numberOfAxles;
	@JsonProperty("OwnerAddress")
	@XmlElement(name = "OwnerAddress")
    String ownerAddress;
	@JsonProperty("OwnerCategory")
	@XmlElement(name = "OwnerCategory")
    String ownerCategory;
	@JsonProperty("OwnerName")
	@XmlElement(name = "OwnerName")
    String ownerName;
	@JsonProperty("RegistrationNumber")
	@XmlElement(name = "RegistrationNumber")
    String registrationNumber;
	@JsonProperty("SittingCapacity")
	@XmlElement(name = "SittingCapacity")
    String sittingCapacity;
	@JsonProperty("TareWeight")
	@XmlElement(name = "TareWeight")
    String tareWeight;
	@JsonProperty("YearOfManufacture")
	@XmlElement(name = "YearOfManufacture")
    String yearOfManufacture;
	 
}