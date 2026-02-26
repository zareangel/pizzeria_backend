package com.restaurante.pizzeria.service;

import com.restaurante.pizzeria.entity.User;
import com.restaurante.pizzeria.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User validateUser(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElse(null);

        if (user == null) return null;

        if (!user.getPassword().equals(password)) return null;

        return user;
    }
}


