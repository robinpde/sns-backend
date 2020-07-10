package org.hov.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.hov.annotation.SNSContactFormat;

public class ContactFormat implements ConstraintValidator<SNSContactFormat, String> {
  String regexp;
  
  @Override
  public void initialize(SNSContactFormat snsContactFormat) {
  /** Standard: E.164 (International public telecommunication number for networks)
   * 1. All Characters should be numbers 
   * 2. Range is from 8 to 16 characters
   */
	  regexp = "^[0-9]{8,16}$";
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext cxt) {
	  if(StringUtils.isBlank(value)) {
		  return true;
	  }
	  if(!value.isEmpty() && Pattern.matches(regexp, value)) {
		  return true;
	  }
	  return false;
  }
}