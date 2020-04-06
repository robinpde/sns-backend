package org.hov.test;

import static org.junit.Assert.assertTrue;

import org.hov.config.AppConfig;
import org.hov.service.SMSService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class SMSTestCases {
	
	@Autowired
	SMSService smsService;
	
	@Test
	@Ignore
	public void sendSMSValid1(){
		assertTrue(smsService.send("+9197903079222", "Testing SMS"));
	}
}
