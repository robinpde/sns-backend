package org.hov.service;

import java.util.UUID;

import org.hov.model.Vendor;

public interface VendorService {
	public UUID addVendorDetails(Vendor vendor);
	public boolean updateVendorDetails(Vendor vendor);
}
