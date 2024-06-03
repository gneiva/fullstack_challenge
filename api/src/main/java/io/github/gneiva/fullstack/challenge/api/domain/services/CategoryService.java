package io.github.gneiva.fullstack.challenge.api.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.gneiva.fullstack.challenge.api.adapter.entities.Category;
import io.github.gneiva.fullstack.challenge.api.adapter.respository.CategoryRepository;
import io.github.gneiva.fullstack.challenge.api.domain.services.ports.CategoryServicePort;

@Service
public class CategoryService implements CategoryServicePort {
	
    private CategoryRepository categoriaRepository;
    
    public CategoryService(CategoryRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    
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
