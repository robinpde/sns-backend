package org.hov.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.hov.validator.CountryCodeFormat;

@Documented
@Constraint(validatedBy = CountryCodeFormat.class)
@Target({ElementType.FIELD, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)
public @interface SNSCountryCodeFormat {
        public String message() default " format not correct";
        public Class<?>[] groups() default {};
        public Class<? extends Payload>[] payload() default {};
}
