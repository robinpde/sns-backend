package org.hov.service;

import java.util.Date;

import org.hov.enums.SMSType;

public interface SMSService {
	public boolean sendTwilioMessage(SMSType styp, 
									 String countryCode, 
									 String phoneNumber,
									 String userName, 
									 String orderName, 
									 Double orderAmount,
									 Date 	scheduledDate, 
									 String supportContact, 
									 String otpCode);
	
	/** Note - TextLocal service is replaced with Twilio SMS Service
	public boolean sendTextLocalMessage(String number, String message);
	*/
}
