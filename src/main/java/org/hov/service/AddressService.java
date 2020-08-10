package org.hov.service;

import java.util.List;
import java.util.UUID;

import org.hov.model.Address;

public interface AddressService {
	public boolean addAddress(Address address);
	public boolean updateAddress(Address address);
	public boolean disableAddress(UUID addressId);
	public Address getAddressById(UUID addressId);
	public Address getDefaultAddress(UUID userId);
	public boolean setDefaultAddress(UUID userId, UUID addressId);
	public List<Address> getAddressListByUser(UUID userId);
}
