package org.hov.test;

import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.hov.config.AppConfig;
import org.hov.model.Payment;
import org.hov.service.PaymentService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(AppConfig.class)
public class PaymentTestCases {
	@Autowired
	PaymentService paymentService;

	@Test
	@Ignore
	public void addPaymentValid1() {
		Payment p = new Payment();
		p.setPaymentLog("Initial Log:1236");
		assertTrue(paymentService.createPayment(p));
	}
	
	@Test
	@Ignore
	public void updatePaymentValid1(){
		Payment p = paymentService.getPaymentById(UUID.fromString("2a5d8e6e-c5ca-456c-b891-82bb8de04681"));
		p.setPaymentLog("Updated Log");
		assertTrue(paymentService.updatePayment(p));
	}
}
