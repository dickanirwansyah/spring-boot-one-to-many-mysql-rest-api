package com.spring.app.springbootangularcore.validation;

import com.spring.app.springbootangularcore.validation.validator.EmployeeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ANNOTATION_TYPE, TYPE, METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {EmployeeValidator.class})
@Documented
public @interface EmployeeValidation {

    String message() default "EmployeeValidation - Name Not Null";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};
}
