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
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Jacksonized
@XmlAccessorType(XmlAccessType.FIELD)
@Builder
public class CoverNoteHdr {
	
	@JsonProperty("CallBackUrl") 
	@XmlElement(name = "CallBackUrl")
    String callBackUrl="";
	@JsonProperty("CompanyCode") 
	@XmlElement(name = "CompanyCode")
    String companyCode="";
	@JsonProperty("CoverNoteType") 
	@XmlElement(name = "CoverNoteType")
    String coverNoteType="";
	@JsonProperty("InsurerCompanyCode")
	@XmlElement(name = "InsurerCompanyCode")
    String insurerCompanyCode="";
	@JsonProperty("RequestId") 
	@XmlElement(name = "RequestId")
    String requestId="";
	@JsonProperty("SystemCode") 
	@XmlElement(name = "SystemCode")
    String systemCode="";
	@JsonProperty("TranCompanyCode") 
	@XmlElement(name = "TranCompanyCode")
    String tranCompanyCode="";
	 
	
  
}