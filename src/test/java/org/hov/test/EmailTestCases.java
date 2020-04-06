package org.hov.test;

import static org.junit.Assert.assertTrue;

import org.hov.config.AppConfig;
import org.hov.config.EmailTemplate;
import org.hov.enums.Locales;
import org.hov.enums.EmailType;
import org.hov.service.EmailService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class EmailTestCases {
	@Autowired
	EmailService emailService;
	
	@Test
	@Ignore
	public void emailValid1() {
		EmailTemplate template = new EmailTemplate();
		System.out.println("**********************************************************************" + template.getSubject(Locales.HI,EmailType.EMAIL_VERIFICATION));
		System.out.println("**********************************************************************" + template.getBody(Locales.HI,EmailType.EMAIL_VERIFICATION));
		assertTrue(emailService.sendSimpleMail(
							"exdev.robin@outlook.com", 
							//template.getSubject(EmailLocale.HI,EmailType.EMAIL_VERIFICATION), 
							//template.getBody(EmailLocale.HI,EmailType.EMAIL_VERIFICATION)));
							"testsubject", "testbody"));
	}
	
	@Test
	//@Ignore
	public void emailValid2() {
		assertTrue(emailService.sendSimpleMail(
							"exdev.robin@outlook.com",
							"testsubject", 
							"testbody"));
	}
}
