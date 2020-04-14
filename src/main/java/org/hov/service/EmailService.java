package org.hov.service;

import org.hov.enums.EmailType;
import org.hov.enums.Locales;

public interface EmailService {
	public boolean sendSimpleMail(String email, String subject, String text);
	public String buildSubject(Locales loc, EmailType etyp, String orderDesc);
	public String buildBody(Locales loc, 
							EmailType etyp, 
							String userName,
							String orderDesc,
							Double orderAmount,
							String verificationCode,
							String httpLink);
}
