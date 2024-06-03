package io.github.gneiva.fullstack.challenge.api.domain.services.ports;

import java.util.List;

import io.github.gneiva.fullstack.challenge.api.adapter.entities.Category;

public interface CategoryServicePort {

	public List<Category> findAll();

	public Category save(Category category);

	public void deleteById(Long id);

	public Category findById(Long id);
}
