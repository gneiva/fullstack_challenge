package io.github.gneiva.fullstack.challenge.api.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.gneiva.fullstack.challenge.api.adapter.respository.CategoryRepository;
import io.github.gneiva.fullstack.challenge.api.adapter.respository.ProductRepository;
import io.github.gneiva.fullstack.challenge.api.domain.services.CategoryService;
import io.github.gneiva.fullstack.challenge.api.domain.services.ProductService;
import io.github.gneiva.fullstack.challenge.api.domain.services.ports.CategoryServicePort;


@Configuration
public class BeanConfiguration {
	
	@Bean
	CategoryServicePort(CategoryRepositoryPort categoriaRepository) {
		return new CategoryService(categoriaRepository);
    }
	
	@Bean
	ProductServicePort(CategoryRepositoryPort produtoRepository, CategoryServicePort categoryService) {
        return new ProductService(produtoRepository, categoryService);
    }
}
