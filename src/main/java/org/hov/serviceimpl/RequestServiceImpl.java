package org.hov.serviceimpl;

import java.util.UUID;

import org.hov.model.Request;
import org.hov.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequestServiceImpl implements RequestService {
	@Autowired
	RequestService requestDAO;

	@Override
	public boolean createRequest(Request request) {
		return requestDAO.createRequest(request);
	}

	@Override
	public boolean updateRequest(Request request) {
		return requestDAO.updateRequest(request);
	}

	@Override
	public boolean getRequestById(UUID requestId) {
		return requestDAO.getRequestById(requestId);
	}
}