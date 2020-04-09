package org.hov.service;

import java.util.List;
import java.util.UUID;

import org.hov.model.Address;

public interface AddressService {
	public boolean addAddress(Address address);
	public boolean updateAddress(Address address);
	public Address getAddressById(UUID addressId);
	public List<Address> getAddressListByUser(UUID userId);
	public boolean makeAddressDefault(UUID userId, UUID addressId);
	public boolean updateGeoLocation(UUID addressId, long locX,  long locY);
}
