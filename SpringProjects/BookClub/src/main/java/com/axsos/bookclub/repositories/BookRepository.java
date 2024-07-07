package com.axsos.bookclub.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.axsos.bookclub.models.Book;
import com.axsos.bookclub.models.User;

public interface BookRepository extends CrudRepository<Book, Long> {
	
	
	List<Book> findAllByBorrower(User borrower);
	

	@Query("SELECT b FROM Book b WHERE b.borrower IS NULL OR b.borrower != :borrower")
    List<Book> findBooksNotBorrowedByUser(@Param("borrower") User borrower);
}
	
	/*
	 * void deleteBorrower(Book book);
	 */	
	
	

	
	
