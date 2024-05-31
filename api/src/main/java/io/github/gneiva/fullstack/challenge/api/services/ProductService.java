package io.github.gneiva.fullstack.challenge.api.services;

import java.util.List;

import io.github.gneiva.fullstack.challenge.api.models.Product;

public interface ProductService {

	public List<Product> findAll();

	public Product save(Product product);

	public void deleteById(Long id);

	public Product findById(Long id);

}
