package org.hov.service;

import java.util.UUID;

import org.hov.enums.LinkType;
import org.hov.model.OTPLink;

public interface LinkService {
	public OTPLink generateLink(LinkType ltype, String value, String otp);
	public boolean regenerateLinkById(UUID linkId);
	public boolean processLinkById(UUID linkId);
	public OTPLink getLinkById(UUID linkId);
	public boolean updateLink(OTPLink link);
	public boolean resendLinkById(UUID linkId);
}
