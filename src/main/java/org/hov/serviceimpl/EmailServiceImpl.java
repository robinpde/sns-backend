package org.hov.serviceimpl;

import org.hov.config.EmailTemplate;
import org.hov.enums.EmailType;
import org.hov.enums.Locales;
import org.hov.service.EmailService;
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
	public String buildSubject(Locales loc, EmailType etyp, String orderText) {
		EmailTemplate et = new EmailTemplate();
		String subject = et.getSubject(loc, etyp);
		subject = subject.replace("$ZORDER_TEXTZ$", orderText.trim());
		return subject;
	}
	
	@Override
	public String buildBody(Locales loc, 		
							EmailType etyp, 
							String userName,	
							String orderDesc, 
							Double orderAmount,
							String verificationCode, 
							String httpLink) {
		EmailTemplate et = new EmailTemplate();
		
		/* COPY THE BELOW STRING DIRECTLY FROM EMAIL TEMPLATE CLASS */
		String PARAM_LOGO_URL = "$ZLOGO_URL$";
		String PARAM_USER_NAME = "$ZUSER_NAMEZ$";
		String PARAM_ORDER_TEXT = "$ZORDER_TEXTZ$";
		String PARAM_ORDER_AMOUNT = "$ZORDER_AMOUNTZ$";
		String PARAM_VERIFICATION_CODE = "$ZVERIFICATION_CODEZ$";
		String PARAM_HTTP_LINK = "$ZHTTP_LINKZ$";
		
		String body = et.getBody(loc, etyp);
		
		body = body.replace(PARAM_LOGO_URL, "");	//img link from CDN server
		body = body.replace(PARAM_USER_NAME, userName.trim());
		body = body.replace(PARAM_ORDER_TEXT, orderDesc.trim());
		body = body.replace(PARAM_ORDER_AMOUNT, orderAmount.toString());
		body = body.replace(PARAM_VERIFICATION_CODE, verificationCode.trim());
		body = body.replace(PARAM_HTTP_LINK, httpLink.trim());
		
		return body;
	}
}
