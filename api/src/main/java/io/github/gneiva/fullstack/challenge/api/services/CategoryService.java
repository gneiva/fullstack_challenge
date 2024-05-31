package io.github.gneiva.fullstack.challenge.api.services;

import java.util.List;

import io.github.gneiva.fullstack.challenge.api.models.Category;

public interface CategoryService {

	public List<Category> findAll();

	public Category save(Category category);

	public void deleteById(Long id);

	public Category findById(Long id);
}
