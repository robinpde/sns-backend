package org.hov.daoimpl;

import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hov.dao.PaymentDAO;
import org.hov.model.PaymentLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("paymentDAO")
@Transactional
public class PaymentDAOImpl implements PaymentDAO{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean createPayment(PaymentLink payment) {
		try{
			sessionFactory.getCurrentSession().persist(payment);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updatePayment(PaymentLink payment) {
		try{
			sessionFactory.getCurrentSession().update(payment);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean deletePayment(UUID paymentId) {
		try{
			PaymentLink payment = new PaymentLink();
			payment.setPaymentid(paymentId);
			sessionFactory.getCurrentSession().delete(payment);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public PaymentLink getPaymentById(UUID paymentId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
						  "from org.hov.model.Payment where paymentid = :id");
			query.setParameter("id", paymentId);
			return (PaymentLink)query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}