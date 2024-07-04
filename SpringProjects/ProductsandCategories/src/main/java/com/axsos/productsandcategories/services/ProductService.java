package com.axsos.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsos.productsandcategories.models.Category;
import com.axsos.productsandcategories.models.Product;
import com.axsos.productsandcategories.repositories.ProductRepositoy;

@Service
public class ProductService {
	
@Autowired
ProductRepositoy productRepositoy;


public Product createProduct(Product product) {
	return productRepositoy.save(product);
	
}

public List<Product> allProducts(){
	return (List<Product>) productRepositoy.findAll();
	
}


public Product findProduct(Long id){
	Optional<Product> theOptional = productRepositoy.findById(id);
	if (theOptional.isPresent()) {
		return theOptional.get();
	}
	return  null;
	
}

public List<Product> otherProducts(Category category){
	return productRepositoy.findByCategoriesNotContains(category);
}

public List<Product>  joinedProducts(Category category){
	return productRepositoy.findAllByCategories(category);
}


public void joinCategory(Product product , Category category) {
	product.getCategories().add(category);
	productRepositoy.save(product);	

	

	
}




	
	

}
