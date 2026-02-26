package com.restaurante.pizzeria.repository;

import com.restaurante.pizzeria.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByStatusTrue();

    @Query("SELECT p FROM Product p WHERE p.status = true AND p.stock > 0")
    List<Product> findAllActiveProducts();
}

