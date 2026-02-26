package com.restaurante.pizzeria.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sale")
@Getter
@Setter
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private boolean status = true;

    @Column(length = 11, nullable = false)
    private String dni;

    @Column(nullable = false)
    private LocalDate date;

    @Column(length = 100, nullable = false)
    private String client;

    @Column(nullable = false)
    private Double total = 0.0;

    @OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
    private List<DetailSale> details;
}
