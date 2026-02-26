package com.restaurante.pizzeria.controller;

import com.restaurante.pizzeria.dto.SaleDTO;
import com.restaurante.pizzeria.entity.Product;
import com.restaurante.pizzeria.entity.Sale;
import com.restaurante.pizzeria.service.SaleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v3")
@CrossOrigin
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/all")
    public List<Sale> getAllSales() {
        return saleService.findAllSales()
                .stream()
                .filter(Sale::isStatus)
                .toList();
    }

    @PostMapping("/save")
    public Sale saveSale(@RequestBody Sale sale) {
        return saleService.saveSale(sale);
    }

    @PutMapping("/disable/{id}")
    public Sale disableSale(@PathVariable Integer id) {
        return saleService.disableSale(id);
    }
}
