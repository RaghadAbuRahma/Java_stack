package com.axsos.burgertracker.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.burgertracker.models.Burger;
import com.axsos.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	private final BurgerService burgerService;

	public MainController(BurgerService burgerService) {
		this.burgerService = burgerService;
	}

	@RequestMapping("/")
	public String index(@ModelAttribute("burger") Burger burger, Model model) {
		List<Burger> burgers = burgerService.allBurgers();
		model.addAttribute("burgers", burgers);
		return "index.jsp";
	}

	@PostMapping("/new")
	public String create(@ Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
		
		  if (result.hasErrors()) {
		  
		  
		  List<Burger> burgers = burgerService.allBurgers();
		  model.addAttribute("burgers", burgers);
		  
		  
		  return "index.jsp"; }
		 
		burgerService.addBurger(burger);
		return "redirect:/";

	}

}
