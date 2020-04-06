package org.hov.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hov.dao.AddressDAO;
import org.hov.model.Address;
import org.hov.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("addressDAO")
@Transactional
public class AddressDAOImpl implements AddressDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public UUID addAddress(Address address) {		
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.persist(address);
			tx.commit();
			return address.getAddressId();
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
	public boolean updateAddress(Address address) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(address);
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
	public Address getAddressById(UUID addressId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from org.hov.model.Address " +
											"where adminId = :id");
			query.setParameter("id", addressId);
			return (Address) query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Address> getAddressByUser(UUID userId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from org.hov.model.Address " +
											"where userId = :id");
			query.setParameter("id", userId);
			return query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Address getDefaultAddress(UUID userId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from org.hov.model.Address " +
											"where userId = :id " +
											"and defaultAddress = true");
			query.setParameter("id", userId);
			return (Address) query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}