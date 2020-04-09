package org.hov.dao;

import java.util.List;
import java.util.UUID;

import org.hov.model.Brand;

public interface BrandDAO {
	public boolean addBrand(Brand brand);
	public boolean updateBrand(Brand brand);
	public boolean deleteBrand(UUID brandId);
	public Brand getBrandById(UUID brandId);
	public List<Brand> getAllBrands();
}
