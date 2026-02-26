package com.restaurante.pizzeria.service;

import com.restaurante.pizzeria.entity.DetailSale;
import com.restaurante.pizzeria.entity.Product;
import com.restaurante.pizzeria.entity.Sale;
import com.restaurante.pizzeria.repository.ProductRepository;
import com.restaurante.pizzeria.repository.SaleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;

    public SaleService(SaleRepository saleRepository,
                       ProductRepository productRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
    }

    @Transactional
    public Sale saveSale(Sale sale) {

        double total = 0;

        for (DetailSale d : sale.getDetails()) {

            Product product = productRepository.findById(d.getProduct().getId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

            if (!product.isStatus()) {
                throw new RuntimeException("Producto no disponible");
            }

            if (product.getStock() < d.getQuantity()) {
                throw new RuntimeException("Stock insuficiente para " + product.getName());
            }

            // descontar stock
            product.setStock(product.getStock() - d.getQuantity());

            if (product.getStock() == 0) {
                product.setStatus(false);
            }

            productRepository.save(product);

            // completar datos del detalle
            d.setSale(sale);
            d.setPrice(product.getPrice());
            d.setSubtotal(product.getPrice() * d.getQuantity());

            total += d.getSubtotal();
        }

        sale.setTotal(total);

        return saleRepository.save(sale);
    }

    public List<Sale> findAllSales() {
        return saleRepository.findAll();
    }

    public Sale disableSale(Integer id) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        sale.setStatus(false);
        return saleRepository.save(sale);
    }
}
