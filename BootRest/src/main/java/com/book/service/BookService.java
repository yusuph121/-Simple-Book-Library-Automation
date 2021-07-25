package com.book.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.book.model.Book;
import com.book.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
    //Get All Books
	 public List getAllBooks(){
		 List book = new ArrayList<>();
		 bookRepository.findAll().forEach(book::add);
		 return book;
	 }
	
	    //Get Book By Id
	   public Optional<Book> getBook(long id) {
		 
		 return bookRepository.findById(id);
	  }
	
	 // Inserts row into table 
		public void addBook(Book book) {
			bookRepository.save(book);
		}
	
		//update book
		 public void updateBook(Book book,long bookId) {
			 bookRepository.save(book);
		 }
		 //Delete book by id
		 public void deleteBook(long id) {
			 bookRepository.deleteById(id);
		 }


}










