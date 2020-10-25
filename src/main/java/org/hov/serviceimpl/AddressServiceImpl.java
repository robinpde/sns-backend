package org.hov.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.hov.dao.AddressDAO;
import org.hov.model.Address;
import org.hov.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	AddressDAO addressDAO;
	
	@Override
	public boolean addAddress(Address address) {
		return addressDAO.addAddress(transformAddress(address));
	}

	@Override
	public boolean updateAddress(Address address) {
		return addressDAO.updateAddress(transformAddress(address));
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
	public Address getDefaultAddress(UUID userId) {
		return addressDAO.getUserDefaultAddress(userId);
	}
	
	@Override
	public boolean setDefaultAddress(UUID userId, UUID addressId) {
		try {
			Address defaultAddress = addressDAO.getUserDefaultAddress(userId);
			Address currentAddress = addressDAO.getAddressById(addressId);

			if (defaultAddress!=null) {
				defaultAddress.setDefaultAddress(false);
			}
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
	public boolean disableAddress(UUID addressId) {
		Address currentAddress = addressDAO.getAddressById(addressId);
		if(currentAddress!=null) {
			currentAddress.setRemoved(true);
			return addressDAO.updateAddress(currentAddress);
		}
		return false;
	}
	
	/* Helper Function - Format Address Strings */
	private Address transformAddress(Address addr) {
		addr.setAddressName(WordUtils.capitalize(addr.getAddressName()));
		addr.setCity(StringUtils.capitalize(addr.getCity()));
		addr.setState(StringUtils.capitalize(addr.getState()));
		addr.setCountry(StringUtils.capitalize(addr.getCountry()));
		return addr;
	}
}