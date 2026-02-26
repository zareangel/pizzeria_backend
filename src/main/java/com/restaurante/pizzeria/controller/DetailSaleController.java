package com.restaurante.pizzeria.controller;

import com.restaurante.pizzeria.entity.DetailSale;
import com.restaurante.pizzeria.service.DetailSaleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v4/details")
@CrossOrigin
public class DetailSaleController {

    private final DetailSaleService detailSaleService;

    public DetailSaleController(DetailSaleService detailSaleService) {
        this.detailSaleService = detailSaleService;
    }

    @PostMapping("/save")
    public DetailSale save(@RequestBody DetailSale detail) {
        return detailSaleService.saveDetail(detail);
    }
}
