package io.github.gneiva.fullstack.challenge.api.services;

import java.util.List;

import org.springframework.data.domain.Page;

import io.github.gneiva.fullstack.challenge.api.form.ProductForm;
import io.github.gneiva.fullstack.challenge.api.models.Product;

public interface ProductService {

	public Page<Product> findAll(int page, int size, String[] sort);
	
	public List<Product> findAll();

	public Product save(ProductForm productForm);

	public void deleteById(Long id);

	public Product findById(Long id);

}
