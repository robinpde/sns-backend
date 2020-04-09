package org.hov.daoimpl;

import java.util.UUID;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hov.dao.VendorDAO;
import org.hov.model.Admin;
import org.hov.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("vendorDAO")
@Transactional
public class VendorDAOImpl implements VendorDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addVendor(Vendor vendor) {
		try {
			sessionFactory.getCurrentSession().persist(vendor);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateVendor(Vendor vendor) {
		try {
			sessionFactory.getCurrentSession().update(vendor);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	

	@Override
	public boolean deleteVendor(UUID vendorId) {
		try {
			Vendor vendor = new Vendor();
			vendor.setVendorid(vendorId);
			sessionFactory.getCurrentSession().delete(vendor);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Vendor getVendorById(UUID vendorId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
						  "from org.hov.model.Vendor where vendorid = :id");
			query.setParameter("id", vendorId);
			return (Vendor)query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}