package com.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.model.Book;
import com.book.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	//Get All Book Handler
	@GetMapping("/books")
	public List getBooks() {
		
		return bookService.getAllBooks();
	}
    
	//Get Book By ID(Single Book)
	@GetMapping("/books/{id}")
	public Optional<Book> getBookById(@PathVariable("id") long id) {
		
		return bookService.getBook(id);
	}
	
	
	//Enter New Book Handler
	@PostMapping("/books")
	public void addBook(@RequestBody Book book) {
		  bookService.addBook(book);
	}
	
	//Update Book Handler
	@PutMapping("/books/{bookId}")
	public void updateBook(@RequestBody Book book,@PathVariable("bookId") long bookId) {
		bookService.updateBook(book,bookId);
	}
	
	 //Delete Book(Single Book)
	 @DeleteMapping("/books/{id}")
	 public Book deleteBook(@PathVariable("id") long id,Book book) {
		 bookService.deleteBook(id);
		 return book;
	}
	
}
