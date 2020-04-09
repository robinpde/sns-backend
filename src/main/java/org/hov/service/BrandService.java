package org.hov.service;

import java.util.List;
import java.util.UUID;

import org.hov.model.Brand;

public interface BrandService {
	public boolean addBrand(Brand brand);
	public boolean updateBrand(Brand brand);
	public boolean removeBrand(UUID brandId);
	public Brand getBrandById(UUID brandId);
	public List<Brand> getAllBrands();
}
