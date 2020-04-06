package org.hov.service;

public interface SMSService {
	public boolean send(String number, String body);
}
