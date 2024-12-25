package com.shandilya.validation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ISBNValidator implements ConstraintValidator<ValidISBN, String> {

	@Override
	public void initialize(ValidISBN constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(String isbn, ConstraintValidatorContext constraintValidatorContext) {
		return isbn.length() >= 10 && isbn.length() <= 13;
	}
}