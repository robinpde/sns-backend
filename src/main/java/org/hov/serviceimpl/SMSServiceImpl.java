package org.hov.serviceimpl;

import java.net.HttpURLConnection;
import java.net.URL;

import org.hov.service.SMSService;
import org.springframework.stereotype.Component;

@Component
public class SMSServiceImpl implements SMSService{
	@Override
	public boolean send(String numbers, String message) {
		HttpURLConnection conn = null;
		try {
			String data  = "apikey="   + "3KuLVPWB+Tg-ABtKGXz4cwY1D2nOMQz7LeWYBx7Exa" +
						   "&numbers=" + numbers +
						   "&message=" + message +
						   "&sender="  + "ShopNScroll";
			
			conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
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
}