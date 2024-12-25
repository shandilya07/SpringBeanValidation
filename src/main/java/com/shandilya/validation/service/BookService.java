package com.shandilya.validation.service;

import com.shandilya.validation.model.Book;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Validated
public class BookService {

	private final List<Book> books = new ArrayList<>();
	private final AtomicLong counter = new AtomicLong();

	public Book addBook(@Valid @NotNull Book book) {
		// Generate a new ID for the book
		book.setId(counter.incrementAndGet());
		books.add(book);
		return book;
	}

	public List<Book> getAllBooks() {
		return books;
	}

	public Book updateBook(@NotNull Long id, @Valid @NotNull Book bookDetails) {
		Book book = findBookById(id);
		if (book == null) {
			throw new IllegalArgumentException("Book not found with id: " + id);
		}

		book.setTitle(bookDetails.getTitle());
		book.setAuthor(bookDetails.getAuthor());
		book.setPrice(bookDetails.getPrice());
		book.setIsbn(bookDetails.getIsbn());
		return book;
	}

	public void deleteBook(@NotNull Long id) {
		Book book = findBookById(id);
		if (book != null) {
			books.remove(book);
		}
	}

	private Book findBookById(Long id) {
		return books.stream()
			.filter(b -> b.getId().equals(id))
			.findFirst()
			.orElse(null);
	}
}
