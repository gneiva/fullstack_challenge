package io.github.gneiva.fullstack.challenge.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.gneiva.fullstack.challenge.api.models.Product;
import io.github.gneiva.fullstack.challenge.api.respository.ProductRepository;
import io.github.gneiva.fullstack.challenge.api.services.ProductService;

@Service
public class ProductServiceImp implements ProductService {
	
    @Autowired
    private ProductRepository produtoRepository;

    @Override
    public List<Product> findAll() {
        return produtoRepository.findAll();
    }

    @Override
    public Product save(Product product) {
    	product.setAvailable(product.getQuantity() != null && product.getQuantity() > 1);
    	return produtoRepository.save(product);
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
