package org.hov.dao;

import java.util.UUID;

import org.hov.model.PaymentLink;

public interface PaymentDAO {
	public boolean createPayment(PaymentLink payment);
	public boolean updatePayment(PaymentLink payment);
	public boolean deletePayment(UUID paymentId);
	public PaymentLink getPaymentById(UUID paymentId);
}
