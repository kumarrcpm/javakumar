package com.maan.crm.notification.sms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sms {
	private String mobileNo;
	private String mobileCode;
	private String smsContent;
	private String smsRegards;
	private String smsSubject;
	private SmsConfigMasterDto master;
}
