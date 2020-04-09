package org.hov.serviceimpl;

import java.util.UUID;

import org.hov.dao.PaymentDAO;
import org.hov.model.Payment;
import org.hov.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	PaymentDAO paymentDAO;

	@Override
	public boolean createPayment(Payment payment) {
		return paymentDAO.createPayment(payment);
	}

	@Override
	public boolean updatePayment(Payment payment) {
		return paymentDAO.updatePayment(payment);
	}

	@Override
	public Payment getPaymentById(UUID paymentId) {
		return paymentDAO.getPaymentById(paymentId);
	}
}