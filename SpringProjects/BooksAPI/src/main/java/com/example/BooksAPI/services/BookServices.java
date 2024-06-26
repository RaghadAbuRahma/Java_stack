package com.example.BooksAPI.services;

import java.util.List;
import java.util.Optional;

//...
import org.springframework.stereotype.Service;

import com.example.BooksAPI.models.Book;
import com.example.BooksAPI.repositories.BookRepo;
@Service
public class BookServices {
 // adding the book repository as a dependency
 private final BookRepo bookRepository;
 
 public BookServices(BookRepo bookRepository) {
     this.bookRepository = bookRepository;
 }
 // returns all the books
 public List<Book> allBooks() {
     return bookRepository.findAll();
 }
 // creates a book
 public Book createBook(Book b) {
     return bookRepository.save(b);
 }
 // retrieves a book
 public Book findBook(Long id) {
     Optional<Book> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
 public Book updateBook(Long id,String title,String desc,String lang, Integer numOfPages) {
	 Optional<Book> batata = bookRepository.findById(id);
     if(batata.isPresent()) {
    	 Book book = batata.get();
    	 book.setTitle(title);
    	 book.setDescription(desc);
    	 book.setLanguage(lang);
    	 book.setNumberOfPages(numOfPages);
    	 bookRepository.save(book);
    	 return book;
     }
	 	return null ;
	
	 
	 
 
 }
 public void destroy (long id) {
	 
		 bookRepository.deleteById(id);
	 }
	 
 }
 


