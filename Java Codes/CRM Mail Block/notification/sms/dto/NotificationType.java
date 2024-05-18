package com.maan.crm.notification.sms.dto;
 

import lombok.Getter;
import lombok.Setter;

@Getter
public enum NotificationType {
	
	
	MAIL("mail")	,SMS("sms"),WHATSAPP("whatsapp");
	
	 

	public void setType(String type) {
		this.type = type;
	}

	private NotificationType(String type) {
		this.type = type;
	}

	private String type;
}
