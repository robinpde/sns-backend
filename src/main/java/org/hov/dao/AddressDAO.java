package org.hov.dao;

import java.util.List;
import java.util.UUID;

import org.hov.model.Address;

public interface AddressDAO {
	public boolean addAddress(Address address);
	public boolean updateAddress(Address address);
	public boolean deleteAddress(UUID addressID);
	public Address getAddressById(UUID addressId);
	public Address getUserDefaultAddress(UUID userId);
	public List<Address> getAddressListByUser(UUID userId);
}
