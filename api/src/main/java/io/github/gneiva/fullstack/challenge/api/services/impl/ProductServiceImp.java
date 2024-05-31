package io.github.gneiva.fullstack.challenge.api.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import io.github.gneiva.fullstack.challenge.api.form.ProductForm;
import io.github.gneiva.fullstack.challenge.api.infra.exceptions.BusinessException;
import io.github.gneiva.fullstack.challenge.api.models.Category;
import io.github.gneiva.fullstack.challenge.api.models.Product;
import io.github.gneiva.fullstack.challenge.api.respository.CategoryRepository;
import io.github.gneiva.fullstack.challenge.api.respository.ProductRepository;
import io.github.gneiva.fullstack.challenge.api.services.CategoryService;
import io.github.gneiva.fullstack.challenge.api.services.ProductService;

@Service
public class ProductServiceImp implements ProductService {
	
    @Autowired
    private ProductRepository produtoRepository;
    
    @Autowired
    private CategoryService categoryService;

    @Override
    public Page<Product> findAll(int page, int size, String[] sort) {
    	Pageable pageable = PageRequest.of(page, size, Sort.by(parseSort(sort)));
        return produtoRepository.findAll(pageable);
    }
    
    private List<Sort.Order> parseSort(String[] sort) {
        return Arrays.stream(sort)
                     .map(s -> s.split(","))
                     .filter(s -> s.length == 2)
                     .map(s -> new Sort.Order(Sort.Direction.fromString(s[1]), s[0]))
                     .collect(Collectors.toList());
    }
    
    @Override
    public List<Product> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Product save(ProductForm productForm) {
    	
    	if(productForm.categoryId() != null) {
    		Category category = categoryService.findById(productForm.categoryId());
    		if(category != null) {
    			Product product = 
    					new Product(productForm.id(), productForm.name(), productForm.description(), productForm.price(), productForm.quantity(), category);
    			product.setAvailable(product.getQuantity() != null && product.getQuantity() > 1);
    	    	return produtoRepository.save(product);
    		}
    	}
    	
    	throw new BusinessException("Invalid category. Please choose a valid category and try again");
    	
    }

    @Override
    public void deleteById(Long id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public Product findById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }
    
}
