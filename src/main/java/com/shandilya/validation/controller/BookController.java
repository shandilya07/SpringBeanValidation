package com.shandilya.validation.controller;

import com.shandilya.validation.model.Book;
import com.shandilya.validation.service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

	private final BookService bookService;

	@PostMapping
	public ResponseEntity<?> addBook(@Valid @RequestBody Book book,
									 BindingResult bindingResult) {
		// Check if there are validation errors
		if (bindingResult.hasErrors()) {
			Map<String, String> errors = new HashMap<>();
			bindingResult
				.getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		// If no validation errors, proceed with adding the book
		return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateBook(@PathVariable Long id,
										@Valid @RequestBody Book bookDetails,
										BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			Map<String, String> errors = new HashMap<>();
			bindingResult
				.getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		// If no validation errors, proceed with updating the book
		Book updatedBook = bookService.updateBook(id, bookDetails);
		return ResponseEntity.ok(updatedBook);
	}

	@GetMapping
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

}