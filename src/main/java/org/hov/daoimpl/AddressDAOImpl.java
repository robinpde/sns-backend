package org.hov.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hov.dao.AddressDAO;
import org.hov.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("addressDAO")
@Transactional
public class AddressDAOImpl implements AddressDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addAddress(Address address) {		
		try{
			sessionFactory.getCurrentSession().persist(address);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateAddress(Address address) {
		try{
			sessionFactory.getCurrentSession().update(address);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteAddress(UUID addressid) {
		try{
			Address address = new Address();
			address.setAddressid(addressid);
			sessionFactory.getCurrentSession().delete(address);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Address getAddressById(UUID addressId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
						  "from org.hov.model.Address where addressid = :id");
			query.setParameter("id", addressId);
			return (Address)query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Address> getAddressListByUser(UUID userId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
						  "from org.hov.model.Address where userId = :id");
			query.setParameter("id", userId);
			return query.getResultList();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Address getUserDefaultAddress(UUID userId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
						  "from org.hov.model.Address where userId = :id " +
						  "and defaultAddress = true");
			query.setParameter("id", userId);
			return (Address)query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}