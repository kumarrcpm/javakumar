package com.maan.crm.notification.mail.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GetMailTemplateReq {

	@JsonProperty("InsuranceId")
	private String insuranceId;

	@JsonProperty("NotificationApplicable")
	private String NotificationApplicable;
	
	@JsonProperty("Sno")
	private Integer sno ;

}
