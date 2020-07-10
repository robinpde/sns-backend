package org.hov.serviceimpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.hov.enums.Locales;
import org.hov.enums.SMSType;
import org.hov.service.SMSService;
import org.hov.template.SMSText;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SMSServiceImpl implements SMSService{
	//TWILIO Specific Credentials
	public static final String ACCOUNT_SID = "twilio";
	public static final String AUTH_TOKEN = "twilio";
	public static final String TWILIO_NUMBER = "twilio";
	
	//TextLocal Specific Credentials
	public static final String API_KEY = "textlocal";
	public static final String AUTH = "textlocal";
	 

	@Override
	public boolean sendTwilioMessage(String code, String number, String message) {
		try {
			Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
			Message msg = Message.creator(new PhoneNumber("+" + code + number),
										  new PhoneNumber("+" + TWILIO_NUMBER),
											  message).create();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	@Override
	public boolean sendTextLocalMessage(String numbers, String message) {
		HttpURLConnection conn = null;
		try {
			String data  = "apikey="   + API_KEY +
					   	   "&numbers=" + "8954798234359" +
					   	   "&message=" + "testing text message" +
						   "&sender="  + "TXTLCL";
			
			conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			System.out.println(stringBuffer.toString());
			
			return true;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally{
			conn.disconnect();
		}
	}

	@Override
	public String buildMessage(Locales loc, 
							   SMSType styp, 
							   String userName, 
							   String orderName, 
							   Double orderAmount,
							   Date scheduledDate, 
							   String adminContact, 
							   String otpCode,
							   String urlLink) {
		SMSText st = new SMSText();
		String message = st.getText(loc, styp);

		message = message.replace("PARAM_SITE_NAME", "ShopNScroll");
		message = message.replace("PARAM_USER_NAME", userName.trim());
		message = message.replace("PARAM_ORDER_NAME", orderName.trim());
		message = message.replace("PARAM_ORDER_AMOUNT", orderAmount.toString());
		message = message.replace("PARAM_ORDER_DATE", scheduledDate.toString());
		message = message.replace("PARAM_CONTACT_NO", adminContact.trim());
		message = message.replace("PARAM_OTP_CODE", otpCode.trim());
		message = message.replace("PARAM_URL_LINK", urlLink.trim());
				
		return message;
	}
}