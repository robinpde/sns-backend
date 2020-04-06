package org.hov.dao;

import java.util.UUID;

import org.hov.model.Vendor;

public interface VendorDAO {
	public UUID addVendorDetails(Vendor vendor);
	public boolean updateVendorDetails(Vendor vendor);
	public Vendor getVendorById(UUID vendorId);
	public boolean deleteVendor(Vendor vendor);
}
