package com.shandilya.validation.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class Author {

	@NotBlank(message = "{NotBlank.author.name}") // Ensures the string is not null, empty, or only whitespace
	@Size(min = 2, max = 50, message = "{Size.author.name}")
	private String name;

	@Email(message = "Email format is incorrect")
	private String email;

	@Past(message = "{Past.author.dateOfBirth}") // Validates that the date is in the past
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateOfBirth;

}
