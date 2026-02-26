package com.restaurante.pizzeria.service;


import com.restaurante.pizzeria.entity.DetailSale;
import com.restaurante.pizzeria.entity.Product;
import com.restaurante.pizzeria.repository.DetailSaleRepository;
import com.restaurante.pizzeria.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class DetailSaleService {

    private final DetailSaleRepository detailSaleRepository;
    private final ProductRepository productRepository;

    public DetailSaleService(DetailSaleRepository detailSaleRepository,
                             ProductRepository productRepository) {
        this.detailSaleRepository = detailSaleRepository;
        this.productRepository = productRepository;
    }

    public DetailSale saveDetail(DetailSale detail) {

        Product product = productRepository.findById(detail.getProduct().getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        if (product.getStock() < detail.getQuantity()) {
            throw new RuntimeException("Stock insuficiente");
        }

        product.setStock(product.getStock() - detail.getQuantity());
        productRepository.save(product);

        detail.setPrice(product.getPrice());
        detail.setSubtotal(product.getPrice() * detail.getQuantity());

        return detailSaleRepository.save(detail);
    }
}

