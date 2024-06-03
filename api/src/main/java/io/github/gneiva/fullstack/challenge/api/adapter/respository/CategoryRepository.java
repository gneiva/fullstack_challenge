package io.github.gneiva.fullstack.challenge.api.adapter.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.gneiva.fullstack.challenge.api.adapter.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
	