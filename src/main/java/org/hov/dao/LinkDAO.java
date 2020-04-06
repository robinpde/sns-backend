package org.hov.dao;

import java.util.UUID;

import org.hov.model.Link;

public interface LinkDAO {
	public UUID createLink(Link link);
	public boolean updateLink(Link link);
	public Link getLinkById(UUID linkId);
}
