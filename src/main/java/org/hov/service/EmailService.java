package org.hov.service;

import java.util.Date;

import org.hov.enums.EmailType;

public interface EmailService {
	public boolean sendSimpleMail(EmailType etyp,
								  String useremail,
								  String userName, 
								  String orderName,
								  Double orderAmount, 
								  Date scheduledDate, 
								  String supportContact, 
								  String otp);
}
