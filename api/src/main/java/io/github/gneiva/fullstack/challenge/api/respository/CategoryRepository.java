package io.github.gneiva.fullstack.challenge.api.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.gneiva.fullstack.challenge.api.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
	