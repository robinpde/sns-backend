package org.hov.dao;

import java.util.List;
import java.util.UUID;

import org.hov.model.Address;

public interface AddressDAO {
	public UUID addAddress(Address address);
	public boolean updateAddress(Address address);
	public Address getAddressById(UUID addressId);
	public Address getDefaultAddress(UUID userId);
	public List<Address> getAddressByUser(UUID userId);
}
