package com.maan.eway.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data

public class MotorVehicleInfoGetReq {

	@JsonProperty("ReqRegNumber")
	private String reqRegNumber ;
	
	@JsonProperty("ReqChassisNumber")
	private String reqChassisNumber ;
	
}
