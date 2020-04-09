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
	public boolean addVendor(Vendor vendor) {
		return vendorDAO.addVendor(vendor);
	}

	@Override
	public boolean updateVendor(Vendor vendor) {
		return vendorDAO.updateVendor(vendor);
	}
	
	@Override
	public boolean removeVendor(UUID vendorId) {
		return vendorDAO.deleteVendor(vendorId);
	}

	@Override
	public Vendor getVendorById(UUID vendorId) {
		return vendorDAO.getVendorById(vendorId);
	}
}