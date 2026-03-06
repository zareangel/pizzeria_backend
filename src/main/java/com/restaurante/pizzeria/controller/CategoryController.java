package com.restaurante.pizzeria.controller;

import com.restaurante.pizzeria.entity.Category;
import com.restaurante.pizzeria.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAll() {
        return categoryService.getAll();
    }

    @PostMapping
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }
}