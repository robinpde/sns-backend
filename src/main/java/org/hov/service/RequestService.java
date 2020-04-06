package org.hov.service;

import java.util.UUID;

import org.hov.model.Request;

public interface RequestService {
	public boolean createRequest(Request request);
	public boolean updateRequest(Request request);
	public boolean getRequestById(UUID requestId);
}
