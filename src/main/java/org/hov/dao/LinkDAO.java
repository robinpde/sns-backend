package org.hov.dao;

import java.util.UUID;

import org.hov.model.Link;

public interface LinkDAO {
	public UUID createLink(Link link);
	public boolean updateLink(Link link);
	public boolean removeLink(UUID linkId);
	public Link getLinkById(UUID linkId);
}
