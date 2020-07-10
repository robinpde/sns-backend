package org.hov.serviceimpl;

import java.util.Date;
import java.util.UUID;

import org.hov.custom.OTPGenerator;
import org.hov.dao.LinkDAO;
import org.hov.enums.EmailType;
import org.hov.enums.LinkType;
import org.hov.enums.Locales;
import org.hov.enums.SMSType;
import org.hov.model.OTPLink;
import org.hov.model.User;
import org.hov.service.EmailService;
import org.hov.service.LinkService;
import org.hov.service.SMSService;
import org.hov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService{
	@Autowired
	LinkDAO linkDAO;
	
	@Autowired
	UserService userService;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	SMSService smsService;
	
	@Override
	public OTPLink getLinkById(UUID linkId) {
		return linkDAO.getLinkById(linkId);
	}
	
	@Override
	public boolean updateLink(OTPLink link) {
		return linkDAO.updateLink(link);
	}
	
	@Override
	public boolean resendLinkById(UUID linkId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public OTPLink generateLink(LinkType ltype, String value, String otp) {
		OTPLink link = new OTPLink();
		link.setLinkType(ltype);
		link.setLinkValue(value);
		link.setOtp(otp);
		linkDAO.createLink(link);
		return link;
	}
	
	@Override
	public boolean regenerateLinkById(UUID linkId) {
		OTPGenerator otpgen = new OTPGenerator();
		String otp = otpgen.generate(6);
		
		OTPLink oldLink = linkDAO.getLinkById(linkId);
		OTPLink newLink = oldLink;
		newLink.setLinkkey(null);
		newLink.setOtp(otp);
		
		User user = oldLink.getUser();
		user.removeLink(oldLink);
		user.addLink(newLink);
		
		if(userService.updateUser(user)) {
			switch(newLink.getLinkType()) {
			case EMAIL_VERIFICATION:
				if(user.isEmailVerified()) {
					return sendEmail(user.getEmail(),
									 user.getFirstName(),
									 EmailType.USER_EMAIL_VERIFICATION,
									 otp,
									 newLink.getLinkkey());
				}
				break;
				
			case EMAIL_CHANGE:
				if(user.isEmailVerified()) {
					return sendEmail(user.getEmail(),
									 user.getFirstName(),
									 EmailType.USER_EMAIL_CHANGE,
									 otp,
									 newLink.getLinkkey());
				}
				break;
				
			case PHONE_VERIFICATION:
			case PHONE_CHANGE:
			case SUSPEND_ACCOUNT:
			case RESUME_ACCOUNT:
				break;
			case PASSWORD_CHANGE:
				if(user.isEmailVerified()) {
					return sendEmail(user.getEmail(),
									 user.getFirstName(),
									 EmailType.USER_PASSWORD_CHANGE,
									 otp,
									 newLink.getLinkkey());
				}
				
				if(user.isPhoneVerified()) {
					//SMS logic

				}
			default:
				break;
			}
		}
		return false;
	}

	@Override
	public boolean processLinkById(UUID linkId) {
		OTPLink link = linkDAO.getLinkById(linkId);
		User user = link.getUser();
		
		switch(link.getLinkType()) {
		case EMAIL_VERIFICATION:
			user.setEmailVerified(true);
			break;
		case EMAIL_CHANGE:
			user.setEmail(link.getLinkValue());
			user.setEmailVerified(true);
			break;
		case PHONE_VERIFICATION:
			user.setPhoneVerified(true);
			break;
		case PHONE_CHANGE:
			user.setPhone(link.getLinkValue());
			user.setPhoneVerified(true);
			break;
		case SUSPEND_ACCOUNT:
			user.setActive(false);
			break;
		case RESUME_ACCOUNT:
			user.setActive(true);
			break;
		case PASSWORD_CHANGE:
			user.setPassword(link.getLinkValue());
			break;
		}
		
		user.removeLink(link);
		if(userService.updateUser(user)) {
			return true;
		}
		return false;
	}
	
	
/**************************** HELPER FUNCTIONS ********************************/
	private boolean sendEmail(  String email, 
								String username, 
							  	EmailType etyp, 
						 		String otp, 
						 		UUID uuid) {
		String emailSubject = "";
		String emailBody = "";
		
		emailSubject = emailService.buildSubject(Locales.EN, etyp, "", new Date());

		emailBody = emailService.buildBody(Locales.EN, etyp, username, "", 0.0,  new Date(), "", otp, uuid.toString());
		
		if(emailService.sendSimpleMail(email, emailSubject, emailBody)) {
			return true;
		}
		return false;
	}
	
	private boolean sendSMS(String phone, String username, SMSType etyp, String otp, String uuid) {
		String text = "";
		//smsService.buildMessage(Locales.EN, etyp, username, "", "", new Date(), "", otp);
		return true;
	}
}