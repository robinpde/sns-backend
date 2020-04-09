package org.hov.serviceimpl;

import java.util.List;
import java.util.UUID;

import org.hov.dao.RequestDAO;
import org.hov.enums.RequestStatus;
import org.hov.model.Request;
import org.hov.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {
	@Autowired
	RequestDAO requestDAO;

	@Override
	public boolean createRequest(Request request) {
		return requestDAO.addRequest(request);
	}

	@Override
	public boolean updateRequest(Request request) {
		return requestDAO.updateRequest(request);
	}
	
	@Override
	public boolean removeRequest(UUID requestId) {
		return requestDAO.deleteRequest(requestId);
	}

	@Override
	public Request getRequestById(UUID requestId) {
		return requestDAO.getRequestById(requestId);
	}

	@Override
	public List<Request> getRequestListByStatus(RequestStatus requestStatus) {
		return requestDAO.getRequestListByStatus(requestStatus);
	}
}