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
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	CategoryService categoryservice;

	@RequestMapping("/")
	public String index(Model model) {
		List<Product> products = productService.allProducts();
		model.addAttribute("products", products);
		List<Category> categories = categoryservice.allCategories();
		model.addAttribute("categories", categories);

		return "index.jsp";

	}

	@RequestMapping("/newProduct")
	public String productForm(@ModelAttribute("product") Product product) {

		return "productForm.jsp";
	}

	@RequestMapping("/createProduct")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {

			model.addAttribute("product", product);

			return "productForm.jsp";

		} else {
			productService.createProduct(product);

			return "redirect:/";
		}
	}

	@RequestMapping("product/{id}")
	public String findProduct(Model model, @ModelAttribute("id") Long id) {
		Product product = productService.findProduct(id);

			model.addAttribute("product", product);
			List <Category> otherCategories = categoryservice.otherCategories(product);
			model.addAttribute("otherCategories", otherCategories);
			List <Category> joinedCategories = categoryservice.joinedCategories(product);
			model.addAttribute("joinedCategories", joinedCategories);

			
			
		return "product.jsp";

	}
	
@PostMapping("product/{id}/joinCategory")
public String joinCategory(@RequestParam Long categoryId, @PathVariable("id") Long id) {
	Product product = productService.findProduct(id);
	Category category = categoryservice.findCategory(categoryId);
	productService.joinCategory(product, category);
	return "redirect:/product/{id}";

	

	
	
	
	
}
	


}

