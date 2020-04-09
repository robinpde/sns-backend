package org.hov.daoimpl;

import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hov.dao.OrderDAO;
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
	public boolean addOrder(Order order) {
		try{
			sessionFactory.getCurrentSession().persist(order);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateOrder(Order order) {
		try{
			sessionFactory.getCurrentSession().update(order);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteOrder(UUID orderId) {
		try{
			Order order = new Order();
			order.setOrderId(orderId);
			sessionFactory.getCurrentSession().delete(order);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Order getOrderById(UUID OrderId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					 	  "from org.hov.model.Order where orderid = :id");
			query.setParameter("id", OrderId);
			return (Order)query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}