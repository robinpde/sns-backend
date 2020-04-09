package org.hov.service;

import java.util.List;
import java.util.UUID;

import org.hov.enums.RequestStatus;
import org.hov.model.Request;

public interface RequestService {
	public boolean createRequest(Request request);
	public boolean updateRequest(Request request);
	public boolean removeRequest(UUID requestId);
	public Request getRequestById(UUID requestId);
	public List<Request> getRequestListByStatus(RequestStatus requestStatus);
}
