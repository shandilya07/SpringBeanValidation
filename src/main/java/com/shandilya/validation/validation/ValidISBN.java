package com.shandilya.validation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ISBNValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidISBN {
	String message() default "Invalid ISBN";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}