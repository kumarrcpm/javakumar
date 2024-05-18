package com.maan.crm.notification.service;

import java.util.List;

import com.maan.crm.notification.mail.dto.GetMailTemplateReq;
import com.maan.crm.notification.mail.dto.MailTriggerReq;
import com.maan.crm.notification.mail.dto.NotifTemplateRes;
import com.maan.crm.notification.mail.dto.ReadMailReq;
import com.maan.crm.notification.mail.dto.ReadMailRes;
import com.maan.crm.res.SuccessRes;

public interface NotificationService {

	public SuccessRes SendMail(MailTriggerReq req);

	public NotifTemplateRes getGetMailTemplate(GetMailTemplateReq req);

	public List<ReadMailRes> ReadMail(ReadMailReq req);


}
