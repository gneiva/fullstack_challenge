package io.github.gneiva.fullstack.challenge.api.domain.services.ports;

import java.util.List;

import org.springframework.data.domain.Page;

import io.github.gneiva.fullstack.challenge.api.adapter.entities.Product;
import io.github.gneiva.fullstack.challenge.api.form.ProductForm;

public interface ProductServicePort {

	public Page<Product> findAll(int page, int size, String[] sort);
	
	public List<Product> findAll();

	public Product save(ProductForm productForm);

	public void deleteById(Long id);

	public Product findById(Long id);

}
