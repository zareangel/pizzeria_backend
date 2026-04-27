package com.restaurante.pizzeria.controller;

import com.restaurante.pizzeria.entity.Product;
import com.restaurante.pizzeria.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v2/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> findAllActiveProducts() {
        return productService.findAllActiveProducts();
    }

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @PutMapping("/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable int id) {
        return productService.updateProduct(product, id);
    }

    @PatchMapping("/{id}/status")
    public Product updateProductStatus(@PathVariable int id) {
        return productService.updateProductStatus(id);
    }
}
