package com.restaurante.pizzeria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

    @Entity
    @Getter
    @Setter
    @Table(name = "detail_sale")
    public class DetailSale {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        @ManyToOne(optional = false)
        @JoinColumn(name = "sale_id")
        private Sale sale;

        @ManyToOne(optional = false)
        @JoinColumn(name = "product_id")
        private Product product;

        @Column(nullable = false)
        private Integer quantity;

        @Column(nullable = false)
        private Double price;

        @Column(nullable = false)
        private Double subtotal;
    }

