package com.maan.crm.notification.mail.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MailTriggerReq {

	@JsonProperty("InsuranceId")
	private String insuranceId ;
	
	@JsonProperty("MailCc")
	private List<String> mailCc ;
	
	@JsonProperty("MailBCc")
	private List<String> mailBcc ;
	
	@JsonProperty("MailTo")
	private List<String> mailTo ;
	
	@JsonProperty("MailSubject")
	private String mailSubject ;
	
	@JsonProperty("MailBody")
	private String mailBody ;
	
	@JsonProperty("MailRegards")
	private String mailRegards;
}
