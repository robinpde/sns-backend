package org.hov.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.hov.dao.AddressDAO;
import org.hov.model.Address;
import org.hov.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{
	@Autowired
	AddressDAO addressDAO;
	
	@Override
	public boolean addAddress(Address address) {
		if(addressDAO.addAddress(address) != null) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean updateAddress(Address address) {
		return addressDAO.updateAddress(address);
	}

	@Override
	public Address getAddressById(UUID addressId) {
		return addressDAO.getAddressById(addressId);
	}

	@Override
	public List<Address> getAddressByUser(UUID userId) {
		return addressDAO.getAddressByUser(userId);
	}

	@Override
	public boolean makeAddressDefault(UUID userId, UUID addressId) {
		try {
			Address defaultAddress = addressDAO.getDefaultAddress(userId);
			Address currentAddress = addressDAO.getAddressById(addressId);
			currentAddress.setDefaultAddress(true);
			defaultAddress.setDefaultAddress(false);
			
			if (addressDAO.updateAddress(currentAddress) && 
				addressDAO.updateAddress(defaultAddress)) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateWarehouseLocation(UUID addressId, long coordX, long coordY) {
		try {
			Address address = addressDAO.getAddressById(addressId);
			address.setCoordinatesX(coordX);
			address.setCoordinatesY(coordY);
			addressDAO.updateAddress(address);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}