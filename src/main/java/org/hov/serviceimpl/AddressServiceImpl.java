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
		return addressDAO.addAddress(address);
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
	public List<Address> getAddressListByUser(UUID userId) {
		return addressDAO.getAddressListByUser(userId);
	}

	@Override
	public boolean makeAddressDefault(UUID userId, UUID addressId) {
		try {
			Address defaultAddress = addressDAO.getUserDefaultAddress(userId);
			Address currentAddress = addressDAO.getAddressById(addressId);

			defaultAddress.setDefaultAddress(false);
			currentAddress.setDefaultAddress(true);
			
			if (addressDAO.updateAddress(defaultAddress)) {
				return addressDAO.updateAddress(currentAddress);
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
	public boolean updateGeoLocation(UUID addressId, long coordX, long coordY) {
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