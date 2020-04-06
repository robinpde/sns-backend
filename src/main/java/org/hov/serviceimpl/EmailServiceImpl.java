package org.hov.serviceimpl;

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
}
