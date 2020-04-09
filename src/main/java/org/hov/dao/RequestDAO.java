package org.hov.dao;

import java.util.List;
import java.util.UUID;

import org.hov.enums.RequestStatus;
import org.hov.model.Request;

public interface RequestDAO {
	public boolean addRequest(Request request);
	public boolean updateRequest(Request request);
	public boolean deleteRequest(UUID requestId);
	public Request getRequestById(UUID requestId);
	public List<Request> getRequestListByStatus(RequestStatus requestStatus);
}
