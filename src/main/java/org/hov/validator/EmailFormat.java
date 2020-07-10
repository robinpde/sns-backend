package org.hov.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.hov.annotation.SNSEmailFormat;

public class EmailFormat implements ConstraintValidator<SNSEmailFormat, String>{
	String regexp;
	
	@Override
	public void initialize(SNSEmailFormat snsEmail) {
	  /** Universal Email Pattern
	   * Standard: RPC 5322 (Internet Message Format)
	   */
		regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|"
	  			+ "}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-"
	  			+ "\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])"
	  			+ "*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:"
	  			+ "[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-"
	  			+ "9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a"
	  			+ "-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21"
	  			+ "-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])"
	  			+ "+)\\])";
	}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(StringUtils.isBlank(value)) {
			return true;
		}
		if(Pattern.matches(regexp, value)) {
			return true;
		}
		return false;
	}
}