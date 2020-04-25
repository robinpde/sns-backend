package org.hov.dao;

import java.util.UUID;

import org.hov.model.OTPLink;

public interface LinkDAO {
	public UUID createLink(OTPLink link);
	public boolean updateLink(OTPLink link);
	public boolean removeLink(UUID linkId);
	public OTPLink getLinkById(UUID linkId);
}
