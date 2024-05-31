package io.github.gneiva.fullstack.challenge.api.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.gneiva.fullstack.challenge.api.models.Category;
import io.github.gneiva.fullstack.challenge.api.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findAllByCategory(Category category);

}
