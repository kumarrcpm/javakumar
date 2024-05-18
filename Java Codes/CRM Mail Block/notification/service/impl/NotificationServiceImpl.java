package com.maan.crm.notification.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.AndTerm;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.FromTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maan.crm.bean.InsuranceCompanyMaster;
import com.maan.crm.bean.MailMaster;
import com.maan.crm.bean.NotifTemplateMaster;
import com.maan.crm.notification.mail.dto.GetMailTemplateReq;
import com.maan.crm.notification.mail.dto.MailTriggerReq;
import com.maan.crm.notification.mail.dto.NotifTemplateRes;
import com.maan.crm.notification.mail.dto.ReadMailReq;
import com.maan.crm.notification.mail.dto.ReadMailRes;
import com.maan.crm.notification.service.NotificationService;
import com.maan.crm.repository.InsuranceCompanyMasterRepository;
import com.maan.crm.repository.MailMasterRepository;
import com.maan.crm.repository.NotifTemplateMasterRepository;
import com.maan.crm.res.SuccessRes;

@Service
public class NotificationServiceImpl implements NotificationService {

	private Logger log = LogManager.getLogger(NotificationServiceImpl.class);
	
	@Autowired
	private MailMasterRepository mailRepo;
	
	@Autowired
	private NotifTemplateMasterRepository notifRepo;
	
	@Autowired
	private InsuranceCompanyMasterRepository insRepo;

	@Override
	public List<ReadMailRes> ReadMail(ReadMailReq req) {

		List<ReadMailRes> reslist = new ArrayList<ReadMailRes>();
		
		MailMaster mailCred =  mailRepo.findByInsCompanyId(req.getInsuranceId());
		
		Properties props = new Properties();
		
		props.setProperty("mail.store.protocol", "imaps");
		
		props.put("mail.smtp.host", mailCred.getSmtpHost());
		props.put("mail.smtp.port", mailCred.getSmtpPort()==null?"":mailCred.getSmtpPort().toString());
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		try {
			Session session = Session.getInstance(props, null);
			Store store = session.getStore();
			store.connect(mailCred.getSmtpHost(), mailCred.getSmtpUser(), mailCred.getSmtpPwd());
			session.setDebug(true);
			Folder inbox = store.getFolder("INBOX");
			inbox.open(Folder.READ_ONLY);

			SearchTerm sender = new FromTerm(new InternetAddress(req.getFromEmail()));

			long DAY_IN_MS = 1000 * 60 * 60 * 24;
			Date somePastDate = new Date(System.currentTimeMillis() - (10 * DAY_IN_MS));

			SearchTerm olderThan = new ReceivedDateTerm(ComparisonTerm.LT, new Date());
			SearchTerm newerThan = new ReceivedDateTerm(ComparisonTerm.GT, somePastDate);
			SearchTerm Dateand = new AndTerm(olderThan, newerThan);
			SearchTerm DateAndSender = new AndTerm(Dateand, sender);
			
			SearchTerm subject = new SubjectTerm(req.getSubject());
			SearchTerm And = new AndTerm(DateAndSender, subject);
			

			Message[] messages = inbox.search(And);

			for (int i = 0; i < messages.length; i++) {

				Message message = messages[i];

				ReadMailRes res = new ReadMailRes();

				res.setSubject(message.getSubject());
				res.setFrom(message.getFrom()[0].toString());
				
				MimeMultipart content = (MimeMultipart) message.getContent();
				String htmlContent = getTextFromMimeMultipart(content );
				
				res.setMailBody(htmlContent);
				res.setReceivedDate(message.getReceivedDate());

				reslist.add(res);
			}
			store.close();

		} catch (Exception mex) {
			mex.printStackTrace();
		}
		return reslist;
	}

	@Override
	public SuccessRes  SendMail(MailTriggerReq req ) {
		
		SuccessRes res = new SuccessRes();
		
		MailMaster mailCred =  mailRepo.findByInsCompanyId(req.getInsuranceId());
		
 		Properties prop = new Properties();
		prop.put("mail.smtp.host", mailCred.getSmtpHost());
		prop.put("mail.smtp.port", mailCred.getSmtpPort()==null?"":mailCred.getSmtpPort().toString());
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); // TLS

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailCred.getSmtpUser(), mailCred.getSmtpPwd());
			}
		});

		try {
			
			// Mail Framed Req 
			List<String> mailCc      =  req.getMailCc();  
			List<String> mailTo      =  req.getMailTo();
			List<String> mailBcc      =  req.getMailBcc();
			
			if(mailTo!=null && mailTo.size()>0 ) {
				InternetAddress[] addressToo = null;
				InternetAddress[] addressCc = null;

				MimeMessage mimeMessage = new MimeMessage(session);

				mimeMessage.setFrom(new InternetAddress(mailCred.getSmtpUser()));
				
				// Mail To
				addressToo = new InternetAddress[mailTo.size()];
				for (int i = 0; i < mailTo.size(); i++) {
					if (StringUtils.isNotBlank(mailTo.get(i))) { 
						addressToo[i] = new InternetAddress(mailTo.get(i)); 
						mimeMessage.addRecipient(Message.RecipientType.TO, addressToo[i]);
					}
				}

				// Mail Cc
				if (mailCc != null && mailCc.size()>0 ) {
					addressCc = new InternetAddress[mailCc.size()];
					for (int i = 0; i < mailCc.size(); i++) {
						if (StringUtils.isNotBlank(mailCc.get(i))) {
							addressCc[i] = new InternetAddress(mailCc.get(i)); 
							mimeMessage.addRecipient(Message.RecipientType.CC, addressCc[i]); 
						}
					}
				}
				
				// Mail BCc
				if (mailBcc != null && mailBcc.size()>0 ) {
					InternetAddress[] addressBCc = new InternetAddress[mailBcc.size()];
					for (int i = 0; i < mailBcc.size(); i++) {
						if (StringUtils.isNotBlank(mailBcc.get(i))) {
							addressBCc[i] = new InternetAddress(mailBcc.get(i)); 
							mimeMessage.addRecipient(Message.RecipientType.BCC, addressBCc[i]); 
						}
					}
				}
				
				mimeMessage.setSubject(req.getMailSubject());
				mimeMessage.setContent(frameMailTemplate(req.getMailBody(),req.getMailSubject() , req.getInsuranceId(), req.getMailRegards()), "text/html");
				
				
				Transport.send(mimeMessage);
				res.setResponse("Mail successfully sent");
			}
		} catch (MessagingException mex) {
			mex.printStackTrace();
			res.setResponse("Mail Sent Failed");
		}	
		return res;
	}

	@Override
	public NotifTemplateRes getGetMailTemplate(GetMailTemplateReq req) {
		
		NotifTemplateRes res = new NotifTemplateRes();
		
		try {
			
			List<NotifTemplateMaster>  notifDetails = notifRepo.findBySnoAndStatusAndNotificationApplicableAndInsIdAndEffectiveDateLessThanEqualOrderByEntryDateDesc(req.getSno(),"Y",req.getNotificationApplicable(),req.getInsuranceId(), new Date()); 
			
			ModelMapper mapper = new ModelMapper();
			res = mapper.map(notifDetails.get(0), NotifTemplateRes.class);
			
		}catch (Exception e) {
			log.error(e);
		}

		return res;
	}
	
	
	private String frameMailTemplate(String mailContent, String subject, String insuranceId,String Regards) {

		try {
			InsuranceCompanyMaster insData = insRepo.findByInsId(insuranceId);

			StringBuilder html = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/email.html")));

			String val;
			while ((val = br.readLine()) != null) {
				html.append(val);
			}
			String result = html.toString();
			result = result.replace("{MailLogo}", insData.getCompanyLogo());
			result = result.replace("{MailSub}", subject);
			result = result.replace("{MailBody}", mailContent);
			result = result.replace("{MailFooter}", Regards);
			result = result.replace("{MailAddress}", insData.getInsAddress());

			br.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private String getTextFromMimeMultipart(MimeMultipart mimeMultipart)  throws MessagingException, IOException{
	    String result = "";
	    int count = mimeMultipart.getCount();
	    for (int i = 0; i < count; i++) {
	        BodyPart bodyPart = mimeMultipart.getBodyPart(i);
	        if (bodyPart.isMimeType("text/plain")) {
	            result = result + "\n" + bodyPart.getContent();
	            break; // without break same text appears twice in my tests
	        } else if (bodyPart.isMimeType("text/html")) {
	            String html = (String) bodyPart.getContent();
	            result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
	        } else if (bodyPart.getContent() instanceof MimeMultipart){
	            result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
	        }
	    }
	    return result;
	}
	
}
