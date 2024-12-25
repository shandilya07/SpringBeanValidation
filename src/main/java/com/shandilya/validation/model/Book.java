package com.shandilya.validation.model;

import com.shandilya.validation.validation.ValidISBN;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class Book {

	private Long id;

	@NotBlank(message = "Book Title shouldn't be blank") // Ensures the string is not null, empty, or only whitespace
	@Size(min = 1, max = 100, message = "Book title should be between 1 and 100 characters")
	private String title;

	@Valid
	private Author author;

	@Min(value = 1, message = "Book price can't be zero") // Ensures the number is greater than or equal to the specified minimum
	@Max(value = 100, message = "Book price can't be greater than 100") // Ensures the number is less than or equal to the specified maximum
	private double price;

	@ValidISBN // Custom validation for ISBN format
	private String isbn;
}