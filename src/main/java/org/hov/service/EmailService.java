package org.hov.service;

import java.util.Date;

import org.hov.enums.EmailType;
import org.hov.enums.Locales;

public interface EmailService {
	public boolean sendSimpleMail(String email, String subject, String text);
	public String buildSubject(Locales loc, 
							   EmailType etyp,
							   String orderName,
							   Date scheduledDate);
	public String buildBody(Locales loc, 
							EmailType etyp,
							String userName,
							String orderName,
							Double orderAmount,
							Date scheduledDate,
							String adminContact,
							String otpCode,
							String btnLink);
}
