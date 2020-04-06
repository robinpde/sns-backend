package org.hov.service;

import java.util.UUID;

import org.hov.model.Link;

public interface LinkService {
	public boolean createLink(Link link);
	public boolean expireLink(UUID linkId);
	public Link getLinkById(UUID linkId);
}
