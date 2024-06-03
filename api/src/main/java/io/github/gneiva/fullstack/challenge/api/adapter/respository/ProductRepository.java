package io.github.gneiva.fullstack.challenge.api.adapter.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.gneiva.fullstack.challenge.api.adapter.entities.Category;
import io.github.gneiva.fullstack.challenge.api.adapter.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findAllByCategory(Category category);

}
