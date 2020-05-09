package org.hov.service;

import java.util.Date;

import org.hov.enums.EmailType;
import org.hov.enums.Locales;

public interface SMSService {
	public boolean send(String number, String message);
	public String buildMessage(Locales loc, 
							   EmailType etyp,
							   String userName,
							   String orderName,
							   Double orderAmount,
							   Date scheduledDate,
							   String adminContact,
							   String otpCode);
}
