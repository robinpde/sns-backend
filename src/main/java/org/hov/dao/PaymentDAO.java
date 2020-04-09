package org.hov.dao;

import java.util.UUID;

import org.hov.model.Payment;

public interface PaymentDAO {
	public boolean createPayment(Payment payment);
	public boolean updatePayment(Payment payment);
	public boolean deletePayment(UUID paymentId);
	public Payment getPaymentById(UUID paymentId);
}
