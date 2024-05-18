package com.maan.eway.req;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@XmlAccessorType(XmlAccessType.FIELD)

public class VerificationHdrReq {

	@JsonProperty("RequestId")
	@XmlElement(name ="RequestId")
	private String requestId ;
	
	@JsonProperty("CompanyCode")
	@XmlElement(name ="CompanyCode")
	private String companyCode ;
	
	@JsonProperty("SystemCode")
	@XmlElement(name ="SystemCode")
	private String systemCode ;
	


}
