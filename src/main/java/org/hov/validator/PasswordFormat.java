package org.hov.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hov.annotation.SNSPasswordFormat;

public class PasswordFormat implements ConstraintValidator<SNSPasswordFormat, String>{
	String regexp;
	
	@Override
	public void initialize(SNSPasswordFormat snsPass) {
	  /** Password Rules
	   * length must range from  8 to 16
	   * must contain at least 1 digit
	   * must contain at least a lower alphabet
	   * must contain at least a upper alphabet
	   * must contain at least 1 special character
	   * must not contain any white space
	   */
	  regexp = "^(?=.*[0-9])"
              + "(?=.*[a-z])(?=.*[A-Z])"
              + "(?=.*[@#$%^&+=])"
              + "(?=\\S+$).{8,16}$";
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(Pattern.matches(regexp, value)) {
			return true;
		}
		return false;
	}
}