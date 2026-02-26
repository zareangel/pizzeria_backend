package com.restaurante.pizzeria.controller;

import com.restaurante.pizzeria.dto.LoginRequest;
import com.restaurante.pizzeria.entity.User;
import com.restaurante.pizzeria.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        User user = userService.validateUser(request.email, request.password);

        if (user == null)
            return ResponseEntity.status(401).body("Invalid credentials");

        return ResponseEntity.ok(user);
    }
}








