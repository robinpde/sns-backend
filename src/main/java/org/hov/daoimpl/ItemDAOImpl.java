package org.hov.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hov.dao.ItemDAO;
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
	public boolean addItem(Item item) {
		try{
			sessionFactory.getCurrentSession().persist(item);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateItem(Item item) {
		try{
			sessionFactory.getCurrentSession().update(item);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean deleteItem(UUID itemId) {
		try{
			Item item = new Item();
			item.setItemid(itemId);
			sessionFactory.getCurrentSession().delete(item);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Item getItemById(UUID itemId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					  	  "from org.hov.model.Item where itemid = :id");
			query.setParameter("id", itemId);
			return (Item)query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Item> getItemList() {
		try {
			return sessionFactory.getCurrentSession().createQuery(
				   "from org.hov.model.Item").list();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Item> getItemListbyPrice() {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					  	  "from org.hov.model.Item " + 
						  "order by itemPrice asc");
			return query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Item> getItemListbyPriceDesc() {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					  	  "from org.hov.model.Item " + 
						  "order by itemPrice desc");
			return query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Item> getItemBySearch(String text) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					  	  "from org.hov.model.Item " + 
						  "where itemName like :txt");
			return query.setParameter("txt", "%"+text+"%").getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}