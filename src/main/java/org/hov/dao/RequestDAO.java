package org.hov.dao;

import java.util.UUID;

import org.hov.model.Request;

public interface RequestDAO {
	public UUID createRequest(Request request);
	public boolean updateRequest(Request request);
	public Request getRequestById(UUID requestId);
}
