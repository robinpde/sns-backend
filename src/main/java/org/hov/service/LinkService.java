package org.hov.service;

import java.util.UUID;

import org.hov.model.OTPLink;

public interface LinkService {
	public boolean generateLink(OTPLink link);
	public boolean regenerateLink(UUID linkId);
	public boolean updateLink(OTPLink link);
	public boolean removeLink(UUID linkId);
	public OTPLink getLinkById(UUID linkId);
}
