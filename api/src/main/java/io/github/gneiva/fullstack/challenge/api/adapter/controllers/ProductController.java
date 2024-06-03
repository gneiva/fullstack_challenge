package io.github.gneiva.fullstack.challenge.api.adapter.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.gneiva.fullstack.challenge.api.adapter.entities.Product;
import io.github.gneiva.fullstack.challenge.api.domain.services.ProductService;
import io.github.gneiva.fullstack.challenge.api.form.ProductForm;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    
    @GetMapping
    public Page<Product> findAll(@RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(defaultValue = "id,asc") String[] sort) {
        return productService.findAll(page, size, sort);
    }
     
    @GetMapping("/all")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product save(@RequestBody ProductForm productForm) {
        return productService.save(productForm);
    }
    
    @PutMapping("/{id}")
    public Product edit(@RequestBody ProductForm productFrom) {
    	return productService.save(productFrom);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
