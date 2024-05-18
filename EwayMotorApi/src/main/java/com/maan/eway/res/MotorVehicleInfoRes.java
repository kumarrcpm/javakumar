package com.maan.eway.res;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data

public class MotorVehicleInfoRes {

	@JsonProperty("ReqRegNumber")
	private String reqRegNumber;

	@JsonProperty("ReqChassisNumber")
	private String reqChassisNumber;

	@JsonProperty("ReqRequestId")
	private String reqRequestId;

	@JsonProperty("ReqCompanyCode")
	private String reqCompanyCode;

	@JsonProperty("ReqSystemCode")
	private String reqSystemCode;

	@JsonProperty("ReqMotorCategory")
	private String reqMotorCategory;

	@JsonProperty("ReqMsgSignature")
	private String reqMsgSignature;

	@JsonFormat(pattern = "dd/MM/yyy")
	@JsonProperty("EntryDate")
	private Date entryDate;

	@JsonProperty("Status")
	private String status;

	@JsonProperty("CreatedBy")
	private String createdBy;

	@JsonProperty("ResResponseId")
	private String resResponseId;

	@JsonProperty("ResRequestId")
	private String resRequestId;

	@JsonProperty("ResStatusCode")
	private String resStatusCode;

	@JsonProperty("ResStatusDesc")
	private String resStatusDesc;

	@JsonProperty("MotorCategory")
	private String resMotorCategory;

	@JsonProperty("Registrationnumber")
	private String resRegNumber;

	@JsonProperty("Chassisnumber")
	private String resChassisNumber;

	@JsonProperty("Vehiclemake")
	private String resMake;

	@JsonProperty("Vehcilemodel")
	private String resModel;

	@JsonProperty("VehicleType")
	private String resBodyType;

	@JsonProperty("Color")
	private String resColor;

	@JsonProperty("EngineNumber")
	private String resEngineNumber;

	@JsonProperty("ResEngineCapacity")
	private String resEngineCapacity;

	@JsonProperty("FuelType")
	private String resFuelUsed;

	@JsonProperty("NumberOfAxels")
	private String resNumberOfAxles;

	@JsonProperty("AxelDistance")
	private String resAxleDistance;

	@JsonProperty("SeatingCapacity")
	private String resSittingCapacity;

	@JsonProperty("ManufactureYear")
	private String resYearOfManufacture;

	@JsonProperty("Tareweight")
	private String resTareWeight;

	@JsonProperty("Grossweight")
	private String resGrossWeight;

	@JsonProperty("Motorusage")
	private String resMotorUsage;

	@JsonProperty("ResOwnerName")
	private String resOwnerName;

	@JsonProperty("OwnerCategory")
	private String resOwnerCategory;

	@JsonProperty("ResMsgSignature")
	private String resMsgSignature;
	
	@JsonProperty("SavedFrom")
	private String savedFrom;
	
	@JsonProperty("PolicyYn")
	private String policyYn;

}
