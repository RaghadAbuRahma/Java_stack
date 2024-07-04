package com.axsos.productsandcategories.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.productsandcategories.models.Category;
import com.axsos.productsandcategories.models.Product;
import com.axsos.productsandcategories.services.CategoryService;
import com.axsos.productsandcategories.services.ProductService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CategoryController {
	
@Autowired
private CategoryService categoryservice;

@Autowired
private ProductService productService;


@RequestMapping("/newCategory")
public String productForm(@ModelAttribute("category") Category category) {
	
	return "categoryForm.jsp";
}


@RequestMapping("/createCategory")
public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result, Model model,
		HttpSession session) {
	if (result.hasErrors()) {

		model.addAttribute("category", category);

		return "categoryForm.jsp";

	} else {
		 categoryservice.createCategory(category);

		return "redirect:/";
	}
}

@RequestMapping("category/{id}")
public String findCategory(Model model, @ModelAttribute("id") Long id) {
	Category category = categoryservice.findCategory(id);
			model.addAttribute("category", category);
	List <Product> otherProducts = productService.otherProducts(category);
	model.addAttribute("otherProducts", otherProducts);
	List <Product> joinedProducts = productService.joinedProducts(category);
	model.addAttribute("joinedProducts", joinedProducts);
			
		
		return "category.jsp";

	}

@PostMapping("category/{id}/joinProduct")
public String joinProduct(@RequestParam Long productId, @PathVariable("id") Long id) {
	Product product = productService.findProduct(productId);
	Category category = categoryservice.findCategory(id);
	categoryservice.joinProduct(product, category);
	return "redirect:/category/{id}";


	
	
}
}
