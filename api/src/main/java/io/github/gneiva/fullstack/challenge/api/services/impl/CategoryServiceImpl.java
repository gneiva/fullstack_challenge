package io.github.gneiva.fullstack.challenge.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.gneiva.fullstack.challenge.api.models.Category;
import io.github.gneiva.fullstack.challenge.api.models.Product;
import io.github.gneiva.fullstack.challenge.api.respository.CategoryRepository;
import io.github.gneiva.fullstack.challenge.api.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
    @Autowired
    private CategoryRepository categoriaRepository;

    @Override
    public List<Category> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoriaRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public Category findById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }
	
    
}
