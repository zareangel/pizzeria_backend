package com.restaurante.pizzeria.repository;

import com.restaurante.pizzeria.entity.DetailSale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailSaleRepository extends JpaRepository<DetailSale, Integer> {
    List<DetailSale> findBySaleId(Integer saleId);
}
