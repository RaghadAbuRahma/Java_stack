package com.example.BooksAPI.controllers;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.BooksAPI.models.Book;
import com.example.BooksAPI.services.BookServices;





@Controller
public class BookController {
	
	
	private final BookServices bookServices;
    public BookController(BookServices bookServices){
        this.bookServices = bookServices;
	
    }
    
	@RequestMapping("/books/{id}")
	public String showBook(Model model, @PathVariable("id") Long id ) {
		Book book = bookServices.findBook(id);
		String title = book.getTitle();
		String description = book.getDescription();
		String lan = book.getLanguage();
		int numberOfPages = book.getNumberOfPages();
		Date createdAt = book.getCreatedAt();
		Date updatedAt = book.getUpdatedAt();
		model.addAttribute("title", title);
		model.addAttribute("desc", description);
		model.addAttribute("lan", lan);
		model.addAttribute("num", numberOfPages);
		model.addAttribute("creat", createdAt);
		model.addAttribute("update", updatedAt);
//		model.addAttribute("book", book);
	

		return "show.jsp";	
	}

}
