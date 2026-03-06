package com.restaurante.pizzeria.repository;

import com.restaurante.pizzeria.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}