package org.hov.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hov.dao.UserDAO;
import org.hov.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) {
		try{
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUser(User user) {
		try{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean deleteUser(UUID userId) {
		try{
			User user = new User();
			user.setUserid(userId);
			sessionFactory.getCurrentSession().delete(user);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public User getUserById(UUID userId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
						  "from org.hov.model.User where userid = :id");
			query.setParameter("id", userId);
			return (User)query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public User getUserByEmail(String email) {		
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
						  "from org.hov.model.User where email = :email");
			query.setParameter("email", email);
			return (User)query.getResultList().get(0);
		}
		catch(Exception e) {
			return null;
		}
	}

	@Override
	public User getUserByPhone(String phone) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
						  "from org.hov.model.User where phone = :phone");
			query.setParameter("phone", phone);
			return (User)query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> getAllUsers() {
		try {
			return sessionFactory.getCurrentSession().createQuery(
				   "from org.hov.model.User").list();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}