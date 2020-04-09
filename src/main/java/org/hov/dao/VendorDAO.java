package org.hov.dao;

import java.util.UUID;

import org.hov.model.Vendor;

public interface VendorDAO {
	public boolean addVendor(Vendor vendor);
	public boolean updateVendor(Vendor vendor);
	public boolean deleteVendor(UUID vendorId);
	public Vendor getVendorById(UUID vendorId);
}
