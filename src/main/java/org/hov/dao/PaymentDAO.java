package org.hov.dao;

import java.util.UUID;

import org.hov.model.Payment;

public interface PaymentDAO {
	public UUID createPayment(Payment payment);
	public boolean updatePayment(Payment payment);
	public Payment getPaymentById(UUID paymentId);
}
