package org.hov.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.hov.validator.UniqueEmail;

@Documented
@Constraint(validatedBy = UniqueEmail.class)
@Target({ElementType.FIELD, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)
public @interface SNSUniqueEmail {
        public String message() default " is already registered";
        public Class<?>[] groups() default {};
        public Class<? extends Payload>[] payload() default {};
}
