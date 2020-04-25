package org.hov.service;

import java.util.UUID;

import org.hov.model.PaymentLink;

public interface PaymentService {
	public boolean createPayment(PaymentLink payment);
	public boolean updatePayment(PaymentLink payment);
	public PaymentLink getPaymentById(UUID paymentId);
}
