package org.hov.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hov.annotation.SNSUniqueContact;
import org.hov.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueContact implements ConstraintValidator<SNSUniqueContact, String> {
  @Autowired
  UserDAO userDAO;
  
  @Override
  public void initialize(SNSUniqueContact snsUniqueContact) {
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext cxt) {
		if(userDAO.getUserByPhone(value.trim())!=null) {
			return false;
		}
		return true;
	}
}