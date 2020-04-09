package org.hov.service;

import java.util.UUID;

import org.hov.model.Vendor;

public interface VendorService {
	public boolean addVendor(Vendor vendor);
	public boolean updateVendor(Vendor vendor);
	public boolean removeVendor(UUID vendorId);
	public Vendor getVendorById(UUID vendorId);
}
