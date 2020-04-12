package org.hov.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
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
		try {
			sessionFactory.getCurrentSession().persist(admin);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		try {
			sessionFactory.getCurrentSession().update(admin);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean deleteAdmin(String adminId) {
		try {
			Admin admin = new Admin();
			admin.setAdminid(adminId);
			sessionFactory.getCurrentSession().delete(admin);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Admin getAdminbyId(String adminId) {
		try {
			Query query= sessionFactory.getCurrentSession().createQuery(
							"from org.hov.model.Admin where adminid = :id");
			query.setParameter("id", adminId);
			return (Admin)query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Admin> getAllAdmins() {
		try {
			return sessionFactory.getCurrentSession()
				   .createQuery("from org.hov.model.Admin").list();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}