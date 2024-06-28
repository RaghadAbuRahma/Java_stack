package com.axsos.burgertracker.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.axsos.burgertracker.models.Burger;
import com.axsos.burgertracker.services.BurgerService;






@Controller
public class MainController {
	 private final BurgerService burgerService;
	    
	    public MainController(BurgerService burgerService) {
	        this.burgerService = burgerService;
	    }
	@RequestMapping("/")
	public String index(Model model) {
		List<Burger> burgers = burgerService.allBurgers();
		model.addAttribute("burgers", burgers);
		return "index.jsp";
	}

}
