package com.restaurante.pizzeria.service;

import com.restaurante.pizzeria.entity.Product;
import com.restaurante.pizzeria.repository.ProductRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllActiveProducts() {
        return productRepository.findAllActiveProducts();
    }

    public Product saveProduct(Product product) {
        try {
            return productRepository.save(product);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Error al guardar el producto");
        }
    }

    public Product updateProduct(Product product, int id) {

        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setStock(product.getStock());
        existing.setStatus(product.isStatus());
        existing.setImage(product.getImage());
        existing.setDescription(product.getDescription());

        return productRepository.save(existing);
    }

    public Product updateProductStatus(int id) {

        Product existing = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        existing.setStatus(false);
        return productRepository.save(existing);
    }
}
