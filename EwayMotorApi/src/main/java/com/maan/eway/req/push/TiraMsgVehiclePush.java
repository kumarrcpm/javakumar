package com.maan.eway.req.push;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;
 
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name="TiraMsg")
@ToString
@Jacksonized
@XmlAccessorType(XmlAccessType.FIELD)
public class TiraMsgVehiclePush {

	@JsonProperty("MsgSignature")
	@XmlElement(name = "MsgSignature")
	String msgSignature="";
	 
	
	@JsonProperty("MotorCoverNoteRefReq") 
	@XmlElement(name = "MotorCoverNoteRefReq")
	private MotorCoverNoteRefReq motorCoverNoteRefReq;
 


}