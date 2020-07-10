package org.hov.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.hov.annotation.SNSCountryCodeFormat;

public class CountryCodeFormat implements ConstraintValidator<SNSCountryCodeFormat, String> {
  String regexp;
  
  @Override
  public void initialize(SNSCountryCodeFormat snsCountryCodeFormat) {
  /** Standard: E.164 (International public telecommunication number for networks)
   * 1. starts with plus sign
   * 2. followed by a 1 to 4 char country code  
   */
	  regexp = "^[0-9]{1,4}$";
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext cxt) {
	  if(Pattern.matches(regexp, value)) {
		  return true;
	  }
	  return false;
  }
}