package com.axsos.bookclub.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.bookclub.models.Book;
import com.axsos.bookclub.models.User;
import com.axsos.bookclub.services.BookService;
import com.axsos.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	@Autowired
	private UserService userservice;

	@RequestMapping("/books")
	public String books(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		if (session.getAttribute("loggedUser") == null) {
			return "redirect:/";
		}
		User loggedUser = (User) session.getAttribute("loggedUser");

		
		  List<Book> otherBooks = bookService.otherBooks(loggedUser);
		  model.addAttribute("otherBooks", otherBooks);
		 

		
			
			  List<Book> books = bookService.allBooks(); model.addAttribute("books",
			  books);
			 
		 

		List<Book> borrowedBooks = bookService.borrowedBooks(loggedUser);
		model.addAttribute("borrowedBooks", borrowedBooks);

		return "books.jsp";

	}

	@RequestMapping("/details/{id}")
	public String showBook(@PathVariable("id") Long id, Model model) {
		Optional<Book> book = bookService.findBook(id);
		if (book.isPresent()) {
			model.addAttribute("book", book.get());
		} else {
			model.addAttribute("error", "Book not found");
		}
		return "details.jsp";

	}

	@RequestMapping("/newForm")
	public String newForm(@ModelAttribute("book") Book book, Model model, HttpSession session) {
		if (session.getAttribute("loggedUser") == null) {
			return "redirect:/";
		}

		model.addAttribute("book", book);

		return "newBook.jsp";
	}

	@RequestMapping("/goback")
	public String logout() {
		return "redirect:/books";
	}

	@RequestMapping("/newBook")
	public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model,
			HttpSession session) {
		
		if (result.hasErrors()) {
			/*
			 * model.addAttribute("book", new Book());
			 */
			model.addAttribute("book", book);

			return "newBook.jsp";

		} else {
			User loggedUser = (User) session.getAttribute("loggedUser");
			book.setUser(loggedUser);
			bookService.newBook(book);

			return "redirect:/books";
		}
	}

	@RequestMapping("/books/{id}/edit")
	public String editForm(@PathVariable("id") Long id, Model model, HttpSession session) {

	
		/*
		 * User user = userservice.findById(borrowerId);
		 */
	    

		Optional<Book> book = bookService.findBook(id);
		if (book.isPresent()) {
			model.addAttribute("book", book.get());
			Book bookk = book.get();
			User Brrower = bookk.getBorrower();
			
			  bookk.setBorrower(Brrower);
			             model.addAttribute("Brrower", Brrower);


		} else {
			model.addAttribute("error", "Book not found");
		}
		return "edit.jsp";
	}

	@RequestMapping("/books/{id}/update")
	public String updateBook(@PathVariable("id") Long id, @Valid @ModelAttribute("book") Book book,
			BindingResult result, HttpSession session) {
		if (result.hasErrors()) {

			return "edit.jsp";

		} else {

			User loggedUser = (User) session.getAttribute("loggedUser");
			book.setUser(loggedUser);
			bookService.updateBook(book);

			return "redirect:/details/{id}";
		}
	}

	@RequestMapping("/books/{id}/delete")
	public String deleteBook(@PathVariable("id") Long id) {
		bookService.deleteBook(id);
		return "redirect:/books";
	}

	@RequestMapping("/borrow/{id}")
	public String borrowBook(@PathVariable("id") Long id, HttpSession session, Model model) {
		Optional<Book> bookOptional = bookService.findBook(id);
		if (bookOptional.isPresent()) {
			Book book = bookOptional.get();
			User loggedUser = (User) session.getAttribute("loggedUser");
			book.setBorrower(loggedUser);
			bookService.updateBook(book);
		} else {
			model.addAttribute("error", "Book not found");
		}
		return "redirect:/books";
	}
	@RequestMapping("/return/{id}")
	public String returnBook(@PathVariable("id") Long id, HttpSession session, Model model) {
		Optional<Book> bookOptional = bookService.findBook(id);
		if (bookOptional.isPresent()) {
			Book book = bookOptional.get();
			book.setBorrower(null);
			bookService.updateBook(book);
		} else {
			model.addAttribute("error", "Book not found");
		}
		return "redirect:/books";
	}
	
	

}
