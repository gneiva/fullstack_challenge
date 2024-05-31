package io.github.gneiva.fullstack.challenge.api.form;

import java.math.BigDecimal;

public record ProductForm(
		Long id,
		String name,
		String description,
		BigDecimal price,
		Integer quantity,
		Boolean available,
		Long categoryId) {};
  
