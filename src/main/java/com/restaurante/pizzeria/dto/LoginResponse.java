package com.restaurante.pizzeria.dto;

public class LoginResponse {
    public Integer id;
    public String email;
    public String role;
    public String name;

    public LoginResponse(Integer id, String email, String role,String name) {
        this.id = id;
        this.email = email;
        this.role = role;
        this.name = name;
    }
}