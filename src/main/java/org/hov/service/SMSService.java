package org.hov.service;

import java.util.Date;

import org.hov.enums.Locales;
import org.hov.enums.SMSType;

public interface SMSService {
	public boolean sendTwilioMessage(String countryCode, String subscriberNumber, String message);
	public boolean sendTextLocalMessage(String number, String message);
	public String buildMessage(Locales loc, 
							   SMSType styp,
							   String userName,
							   String orderName,
							   Double orderAmount,
							   Date scheduledDate,
							   String adminContact,
							   String otpCode,
							   String urlLink);
}
