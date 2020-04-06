package org.hov.dao;

import java.util.UUID;

import org.hov.model.Brand;

public interface BrandDAO {
	public UUID addBrand(Brand brand);
	public boolean updateBrand(Brand brand);
	public Brand getBrandById(UUID brandId);
}
