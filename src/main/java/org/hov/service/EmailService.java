package org.hov.service;

public interface EmailService {
	public boolean sendSimpleMail(String email, String subject, String text);
}
