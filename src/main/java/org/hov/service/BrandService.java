package org.hov.service;

import java.util.UUID;

import org.hov.model.Brand;

public interface BrandService {
	public boolean addBrand(Brand brand);
	public boolean updateBrand(Brand brand);
	public Brand getBrandById(UUID brandId);
}
