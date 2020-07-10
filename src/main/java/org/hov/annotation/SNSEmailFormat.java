package org.hov.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.hov.validator.EmailFormat;

@Documented
@Constraint(validatedBy = EmailFormat.class)
@Target({ElementType.FIELD, ElementType.METHOD})  
@Retention(RetentionPolicy.RUNTIME)
public @interface SNSEmailFormat {
        public String message() default " format is not correct";
        public Class<?>[] groups() default {};
        public Class<? extends Payload>[] payload() default {};
}
