package org.hov.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hov.dao.OrderDAO;
import org.hov.model.Admin;
import org.hov.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public UUID addOrder(Order order) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.persist(order);
			tx.commit();
			return order.getOrderId();
		}
		catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			return null;
		}
		finally{
			session.close();
		}
	}

	@Override
	public boolean updateOrder(Order order) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(order);
			tx.commit();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			return false;
		}
		finally {
			session.close();
		}
	}

	@Override
	public Order getOrderById(UUID OrderId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from org.hov.model.Order " +
											"where orderId = :id");
			query.setParameter("id", OrderId);
			return (Order) query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Order> getOrderListByUser(UUID userId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from org.hov.model.Order " +
											"where orderId = :id");
			query.setParameter("id", userId);
			return query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}