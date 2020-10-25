package org.hov.serviceimpl;

import java.util.Date;

import org.hov.enums.EmailType;
import org.hov.service.EmailService;
import org.hov.template.EmailText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService
{
	public static String siteEmail = "notifier@shopnscroll.com";
	
	@Autowired
    public JavaMailSender mailSender;
	
	@Override
	public boolean sendSimpleMail(EmailType etyp,
			  					  String useremail,
								  String userName, 
								  String orderName,
								  Double orderAmount, 
								  Date scheduledDate, 
								  String supportContact, 
								  String otp)
	{
		try {
			//Build Email Subject and Body
			EmailText et = new EmailText();
			
			String subject = et.getSubject(etyp);		
			String body = et.getBody(etyp);
			
			subject = subject.replace("PARAM_ORDER_NAME", orderName.trim());
			subject = subject.replace("PARAM_ORDER_DATE", scheduledDate.toString());
			
			body = body.replace("PARAM_USER_NAME", userName.trim());
			body = body.replace("PARAM_ORDER_NAME", orderName.trim());
			body = body.replace("PARAM_ORDER_AMOUNT", orderAmount.toString());
			body = body.replace("PARAM_ORDER_DATE", scheduledDate.toString());
			
			//Send email
	        SimpleMailMessage message = new SimpleMailMessage();
	        
	        message.setFrom(siteEmail);
	        message.setTo(useremail); 
	        message.setSubject(subject); 
	        message.setText(body);
	        
	        mailSender.send(message);
			
	        return true;	//Email sent
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;	//Email not sent
		}
    }
}