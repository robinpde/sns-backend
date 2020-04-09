package org.hov.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hov.dao.RequestDAO;
import org.hov.enums.RequestStatus;
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
	public boolean addRequest(Request request) {
		try {
			sessionFactory.getCurrentSession().persist(request);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateRequest(Request request) {
		try {
			sessionFactory.getCurrentSession().update(request);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean deleteRequest(UUID requestId) {
		try {
			Request request = new Request();
			request.setRequestid(requestId);
			sessionFactory.getCurrentSession().delete(request);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Request getRequestById(UUID requestId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					  	  "from org.hov.model.Request where requestid = :id");
			query.setParameter("id", requestId);
			return (Request) query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Request> getRequestListByStatus(RequestStatus requestStatus) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					  "from org.hov.model.Request where requestStatus = :sts");
			query.setParameter("sts", requestStatus);
			return query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}