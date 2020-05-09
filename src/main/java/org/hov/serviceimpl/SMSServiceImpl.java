package org.hov.serviceimpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

import org.hov.enums.EmailType;
import org.hov.enums.Locales;
import org.hov.service.SMSService;
import org.hov.template.SMSTemplate;
import org.springframework.stereotype.Service;

@Service
public class SMSServiceImpl implements SMSService{
	public static final String API_KEY = "3KuLVPWB+Tg-ABtKGXz4cwY1D2nOMQz7LeWYBx7Exa";
	public static final String AUTH = "9536543c8e785934b1b08f264c7ab510";
	  
	@Override
	public boolean send(String numbers, String message) {
		HttpURLConnection conn = null;
		try {
			String data  = "apikey="   + API_KEY +
					   	   "&numbers=" + "919790307922" +
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
							   EmailType etyp, 
							   String userName, 
							   String orderName, 
							   Double orderAmount,
							   Date scheduledDate, 
							   String adminContact, 
							   String otpCode) {
		SMSTemplate st = new SMSTemplate();
		String message = st.getText(loc, etyp);

		message = message.replace("PARAM_SITE_NAME", "siteName");
		message = message.replace("PARAM_USER_NAME", userName.trim());
		message = message.replace("PARAM_ORDER_NAME", orderName.trim());
		message = message.replace("PARAM_ORDER_AMOUNT", orderAmount.toString());
		message = message.replace("PARAM_ORDER_DATE", scheduledDate.toString());
		message = message.replace("PARAM_CONTACT_NO", adminContact.trim());
		message = message.replace("PARAM_OTP_CODE", otpCode.trim());
				
		return message;
	}
}