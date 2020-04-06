package org.hov.serviceimpl;

import java.util.UUID;

import org.hov.dao.LinkDAO;
import org.hov.model.Link;
import org.hov.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService{
	@Autowired
	LinkDAO linkDAO;
	
	@Override
	public boolean createLink(Link link) {
		if(linkDAO.createLink(link) != null){
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean expireLink(UUID linkId) {
		try {
			Link link =	linkDAO.getLinkById(linkId);
			link.setExpired(true);
			linkDAO.updateLink(link);
			return true;
		} 
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public Link getLinkById(UUID linkId) {
		return linkDAO.getLinkById(linkId);
	}
}