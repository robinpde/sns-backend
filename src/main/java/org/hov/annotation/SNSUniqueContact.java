package org.hov.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.hov.validator.UniqueContact;

@Documented
@Constraint(validatedBy = UniqueContact.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SNSUniqueContact {
    String message() default " is already registered";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}