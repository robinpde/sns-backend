package org.hov.daoimpl;

import java.util.List;
import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hov.dao.BrandDAO;
import org.hov.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("brandDAO")
@Transactional
public class BrandDAOImpl implements BrandDAO{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addBrand(Brand brand) {
		try{
			sessionFactory.getCurrentSession().persist(brand);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateBrand(Brand brand) {
		try{
			sessionFactory.getCurrentSession().update(brand);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteBrand(UUID brandId) {
		try{
			Brand brand = new Brand();
			brand.setBrandid(brandId);
			sessionFactory.getCurrentSession().delete(brand);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Brand getBrandById(UUID brandId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
						  "from org.hov.model.Brand where brandid = :id");
			query.setParameter("id", brandId);
			return (Brand)query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Brand> getAllBrands() {
		return sessionFactory.getCurrentSession().createQuery(
			   "from org.hov.model.Brand").list();
	}
}