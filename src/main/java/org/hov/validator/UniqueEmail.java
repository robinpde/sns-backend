package org.hov.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hov.annotation.SNSUniqueEmail;
import org.hov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueEmail implements ConstraintValidator<SNSUniqueEmail, String>{
	@Autowired
	UserService userService;
	
	@Override
	public void initialize(SNSUniqueEmail snsUniqueEmail) {
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(userService.getUserByEmail(value.trim())!=null) {
			return false;
		}
		return true;
	}
}