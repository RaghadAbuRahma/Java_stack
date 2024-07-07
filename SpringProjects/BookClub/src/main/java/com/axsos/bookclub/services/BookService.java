package com.axsos.bookclub.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsos.bookclub.models.Book;
import com.axsos.bookclub.models.User;
import com.axsos.bookclub.repositories.BookRepository;


@Service
public class BookService {

	
@Autowired
private BookRepository bookRepository;


public List<Book> allBooks(){
return (List<Book>) bookRepository.findAll();
	
}
public Optional<Book> findBook(Long id){
	return bookRepository.findById(id); 

	
}

public Book newBook(Book book) {
	return bookRepository.save(book);
}

public Book updateBook(Book book) {
	return bookRepository.save(book);
}

public void deleteBook(Long id) {
	bookRepository.deleteById (id);
}
public List<Book> borrowedBooks(User borrower) {
    return bookRepository.findAllByBorrower(borrower);
}

public List<Book> otherBooks(User borrower){
        return bookRepository.findBooksNotBorrowedByUser(borrower);
    }
}



