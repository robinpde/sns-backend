package org.hov.daoimpl;

import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hov.dao.RequestDAO;
import org.hov.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("requestDAO")
@Transactional
public class RequestDAOImpl implements RequestDAO{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public UUID createRequest(Request request) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.persist(request);
			tx.commit();
			return request.getRequestId();
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
	public boolean updateRequest(Request request) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(request);
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
	public Request getRequestById(UUID requestId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from org.hov.model.Request " +
											"where requestId = :id");
			query.setParameter("id", requestId);
			return (Request) query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}