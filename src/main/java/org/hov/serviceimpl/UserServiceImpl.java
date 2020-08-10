package org.hov.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import org.hov.custom.OTPGenerator;
import org.hov.dao.UserDAO;
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
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	SMSService smsService;
	
	@Autowired
	LinkService linkService;
	
	@Override
	public boolean addUser(User user) {
		String otp;
		String smsText;
		String emailSubject;
		String emailBody;
		
		OTPLink link = new OTPLink();
		OTPGenerator otpgen = new OTPGenerator();

		try {
			if(!StringUtils.isBlank(user.getEmail())) {
				user.setEmail(user.getEmail().trim().toLowerCase());

				/* Manual Validation Error - Email is already registered */
				/**
				if(userDAO.getUserByEmail(user.getEmail()) != null) {
					
					return false;
				};
				*/
				
				user.setEmailAlert(true);
			}
			else if(!StringUtils.isBlank(user.getPhone())) {
				user.setPhone(user.getPhone().trim());
				
				/* Manual Validation Error - Email is already registered */
				/**
				if(userDAO.getUserByPhone(user.getPhone()) != null) {
				
					return false;
				}
				*/
				
				user.setPhoneAlert(true);
			}
			else {
				/* Manual Validation Error - Email or Phone is mandatory */
				
				return false;
			}
			
			user.setFirstName(WordUtils.capitalize(user.getFirstName().toLowerCase()));
			user.setLastName(WordUtils.capitalize(user.getLastName().toLowerCase()));
			user.setCountryCode(user.getCountryCode().trim());
			user.setEmailVerified(false);
			user.setPhoneVerified(false);
			user.setDarkMode(false);
			user.setActive(true);
			//user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
			
			/* Generate OTP Link for Email */
			otp = otpgen.generate(6);
			link.setOtp(otp);
			
			if(userDAO.addUser(user)){
				
				if(user.hasEmailAlert()) {
					
					link.setLinkType(LinkType.EMAIL_VERIFICATION);
					link.setLinkValue(user.getEmail());
					user.addLink(link);
					updateUser(user);
					
					/* Send Verification Email */
					/**
					emailSubject = emailService.buildSubject(Locales.EN, 
										      				 EmailType.USER_EMAIL_VERIFICATION,
										      				 "", 
											  				 new Date());
	
					emailBody = emailService.buildBody(Locales.EN, 
										   			   EmailType.USER_EMAIL_VERIFICATION, 
										   			   user.getFirstName(), 
										   			   "", 
										   			   0.0, 
										   			   new Date(), 
										   			   "",
										   			   otp, 
										   			   link.getLinkkey().toString());
					
					if (!emailService.sendSimpleMail(user.getEmail(), emailSubject, emailBody)) {
						user.removeLink(link);
						updateUser(user);
						userDAO.deleteUser(user.getUserid());
						return false;
					}
					*/
				}

				if(user.hasPhoneAlert()) {
					link.setLinkType(LinkType.EMAIL_VERIFICATION);
					link.setLinkValue(user.getPhone());
					user.addLink(link);
					updateUser(user);
					
					/* Send Verification SMS */
					/**
					smsText = smsService.buildMessage(Locales.EN, 
													  SMSType.USER_PHONE_VERIFICATION, 
													  user.getFirstName(), 
													  "", 
													  0.0, 
													  new Date(), 
													  "", 
													  otp,
													  link.getLinkkey().toString());
					
					if (!smsService.sendTwilioMessage(user.getCountryCode(), user.getPhone(), smsText)) {
						user.removeLink(link);
						updateUser(user);
						userDAO.deleteUser(user.getUserid());
						return false;
					}
					*/
				}
			}
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateUser(User user) {
		user.setFirstName(WordUtils.capitalize(user.getFirstName().toLowerCase()));
		user.setLastName(WordUtils.capitalize(user.getLastName().toLowerCase()));
		return userDAO.updateUser(user);
	}
	
	@Override
	public boolean removeUser(UUID userId) {
		return userDAO.deleteUser(userId);
	}

	@Override
	public User getUserById(UUID userId) {
		return userDAO.getUserById(userId);
	}

	@Override
	public User getUserByEmail(String email) {
		return userDAO.getUserByEmail(email);
	}

	@Override
	public User getUserByPhone(String phone) {
		return userDAO.getUserByPhone(phone);
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.getAllUsers();
	}

	@Override
	public boolean activateUser(UUID userId) {
		try{
			User user = userDAO.getUserById(userId);
			user.setActive(true);
			userDAO.updateUser(user);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deactivateUser(UUID userId) {
		try{
			User user = userDAO.getUserById(userId);
			user.setActive(false);
			userDAO.updateUser(user);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
