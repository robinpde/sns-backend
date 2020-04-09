package org.hov.service;

import java.util.UUID;

import org.hov.model.Link;

public interface LinkService {
	public boolean generateLink(Link link);
	public boolean regenerateLink(UUID linkId);
	public boolean updateLink(Link link);
	public boolean removeLink(UUID linkId);
	public Link getLinkById(UUID linkId);
}
