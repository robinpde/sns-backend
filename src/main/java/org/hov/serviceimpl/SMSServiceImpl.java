package org.hov.serviceimpl;

/** Note - TextLocal service is replaced with Twilio SMS Service
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
*/

import java.util.Date;

import org.hov.enums.SMSType;
import org.hov.service.SMSService;
import org.hov.template.SMSText;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SMSServiceImpl implements SMSService{
	
	//TWILIO Specific Variables
	public static final String ACCOUNT_SID = "twilio_sid";
	public static final String AUTH_TOKEN = "twilio_token";
	public static final String TWILIO_NUMBER = "twilio_number";

	@Override
	public boolean sendTwilioMessage(SMSType styp,
									 String countryCode,
									 String phoneNumber,
									 String userName,
									 String orderName,
									 Double orderAmount,
									 Date 	scheduledDate,
									 String supportContact,
									 String otpCode) {
		try {
			//Build Message
			SMSText st = new SMSText();
			String message = st.getText(styp);

			message = message.replace("PARAM_USER_NAME", userName.trim());
			message = message.replace("PARAM_ORDER_NAME", orderName.trim());
			message = message.replace("PARAM_ORDER_AMOUNT", orderAmount.toString());
			message = message.replace("PARAM_ORDER_DATE", scheduledDate.toString());
			message = message.replace("PARAM_CONTACT_NO", supportContact.trim());
			message = message.replace("PARAM_OTP_CODE", otpCode.trim());
			
			//Sent Message
			Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
			Message msg = Message.creator(new PhoneNumber("+" + countryCode + phoneNumber),
										  new PhoneNumber("+" + TWILIO_NUMBER),
										  message).create();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;	//Twilio HTTP request not submitted
		}
		return true;		//Twilio HTTP request submitted
	}

	
	/** Note - TextLocal service is replaced with Twilio SMS Service
	//TextLocal Specific Variables
	public static final String API_KEY = "textlocal_api_key";
	public static final String AUTH = "textlocal_auth";
	
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
	*/
}