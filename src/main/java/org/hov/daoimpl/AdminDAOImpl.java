package org.hov.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hov.dao.AdminDAO;
import org.hov.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("adminDAO")
@Transactional
public class AdminDAOImpl implements AdminDAO{
	@Autowired
	SessionFactory sessionFactory;
		
	@Override
	public boolean addAdmin(Admin admin) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.persist(admin);
			tx.commit();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			return false;
		}
		finally{
			session.close();
		}
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(admin);
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
	public Admin getAdminbyId(String adminId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from org.hov.model.Admin " +
											"where adminId = :id");
			query.setParameter("id", adminId);
			return (Admin) query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Admin> getAllAdmins() {
		try {
			Session session = sessionFactory.getCurrentSession();
			return session.createQuery("from org.hov.model.Admin").list();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}