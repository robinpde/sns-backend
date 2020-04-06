package org.hov.serviceimpl;

import java.util.UUID;

import org.hov.dao.VendorDAO;
import org.hov.model.Vendor;
import org.hov.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService{
	@Autowired
	VendorDAO vendorDAO;
	
	@Override
	public UUID addVendorDetails(Vendor vendor) {
		return vendorDAO.addVendorDetails(vendor);
	}

	@Override
	public boolean updateVendorDetails(Vendor vendor) {
		return vendorDAO.updateVendorDetails(vendor);
	}
}