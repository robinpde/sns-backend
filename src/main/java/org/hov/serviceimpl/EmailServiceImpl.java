package org.hov.serviceimpl;

import java.util.Date;

import org.hov.enums.EmailType;
import org.hov.enums.Locales;
import org.hov.service.EmailService;
import org.hov.template.EmailTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService
{
	@Autowired
    public JavaMailSender emailSender;
	
	@Override
	public boolean sendSimpleMail(String email, String subject, String text)
	{
		try
		{
	        SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setTo(email); 
	        message.setSubject(subject); 
	        message.setText(text);
	        emailSender.send(message);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
    }

	@Override
	public String buildSubject(Locales loc, 
			   				   EmailType etyp, 
			   				   String orderName, 
			   				   Date scheduledDate) {
		EmailTemplate et = new EmailTemplate();
		String subject = et.getSubject(loc, etyp);
		
		subject = subject.replace("PARAM_ORDER_NAME", orderName.trim());
		subject = subject.replace("PARAM_ORDER_DATE", scheduledDate.toString());
		
		return subject;
	}
	
	@Override
	public String buildBody(Locales loc, 
							EmailType etyp,
							String userName, 
							String orderName,
							Double orderAmount, 
							Date scheduledDate, 
							String adminContact, 
							String otpCode, 
							String btnLink) {
		EmailTemplate et = new EmailTemplate();
		
		String body = et.getBody(loc, etyp);
		
		body = body.replace("PARAM_SITE_NAME", "siteName"); 	//site name
		body = body.replace("PARAM_SITE_LOGO", "logoCDN");		//ogo CDN URL
		body = body.replace("PARAM_USER_NAME", userName.trim());
		body = body.replace("PARAM_ORDER_NAME", orderName.trim());
		body = body.replace("PARAM_ORDER_AMOUNT", orderAmount.toString());
		body = body.replace("PARAM_ORDER_DATE", scheduledDate.toString());
		body = body.replace("PARAM_OTP_CODE", otpCode.trim());
		body = body.replace("PARAM_BUTTON_LINK", btnLink.trim());
		
		return body;
	}
}