package org.hov.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.hov.dao.BrandDAO;
import org.hov.model.Brand;
import org.hov.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService{
	@Autowired
	BrandDAO brandDAO;

	@Override
	public boolean addBrand(Brand brand) {
		return brandDAO.addBrand(brand);
	}

	@Override
	public boolean updateBrand(Brand brand) {
		return brandDAO.updateBrand(brand);
	}

	@Override
	public Brand getBrandById(UUID brandId) {
		return brandDAO.getBrandById(brandId);
	}

	@Override
	public List<Brand> getAllBrands() {
		return brandDAO.getAllBrands();
	}

	@Override
	public boolean removeBrand(UUID brandId) {
		return brandDAO.deleteBrand(brandId);
	}
}