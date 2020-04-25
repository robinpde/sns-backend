package org.hov.daoimpl;

import java.util.UUID;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.hov.dao.LinkDAO;
import org.hov.model.OTPLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("linkDAO")
@Transactional
public class LinkDAOImpl implements LinkDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public UUID createLink(OTPLink link) {
		try {
			sessionFactory.getCurrentSession().persist(link);
			return link.getLinkkey();
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean updateLink(OTPLink link) {
		try {
			sessionFactory.getCurrentSession().update(link);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean removeLink(UUID linkId) {
		try {
			OTPLink link = new OTPLink();
			link.setLinkkey(linkId);
			sessionFactory.getCurrentSession().delete(link);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public OTPLink getLinkById(UUID linkId) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					      "from org.hov.model.Link where linkkey = :id");
			query.setParameter("id", linkId);
			return (OTPLink)query.getResultList().get(0);
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}