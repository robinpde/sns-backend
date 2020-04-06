package org.hov.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hov.dao.ItemDAO;
import org.hov.model.Admin;
import org.hov.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("itemDAO")
@Transactional
public class ItemDAOImpl implements ItemDAO{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public UUID addItem(Item item) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.persist(item);
			tx.commit();
			return item.getItemId();
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
	public boolean updateItem(Item item) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(item);
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
	public Item getItemById(UUID itemId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query=session.createQuery("from org.hov.model.Item " +
											"where itemId = :id");
			query.setParameter("id", itemId);
			return (Item) query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Item> getItemList() {
		try {
			Session session = sessionFactory.getCurrentSession();
			return session.createQuery("from org.hov.model.Item").list();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Item> getItemListFullDetails() {
		try {
			Session session = sessionFactory.getCurrentSession();
			return session.createQuery("from org.hov.model.Item").list();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}