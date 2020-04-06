package org.hov.service;

import java.util.UUID;

import org.hov.model.Payment;

public interface PaymentService {
	public boolean createPayment(Payment payment);
	public boolean updatePayment(Payment payment);
	public Payment getPaymentById(UUID paymentId);
}
