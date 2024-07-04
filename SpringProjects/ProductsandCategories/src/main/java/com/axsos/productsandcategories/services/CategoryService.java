package com.axsos.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsos.productsandcategories.models.Category;
import com.axsos.productsandcategories.models.Product;
import com.axsos.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	
@Autowired
private CategoryRepository categoryRepository;



public Category createCategory(Category category) {
	return categoryRepository.save(category);
	
}

public List<Category> allCategories(){
	return (List<Category>) categoryRepository.findAll();
	
}


public Category findCategory(Long id){
	Optional<Category> theOptional = categoryRepository.findById(id);
	if (theOptional.isPresent()) {
		return theOptional.get();
	}
	return null;
}

public List<Category> otherCategories(Product product){
	return categoryRepository.findByProductsNotContains(product);
}

public List<Category>  joinedCategories(Product product){
	return categoryRepository.findAllByProducts(product);
}

public void joinProduct(Product product , Category category) {
	category.getProducts().add(product);
	categoryRepository.save(category);	

	
	
	
}


}
