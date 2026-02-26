package com.restaurante.pizzeria.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.restaurante.pizzeria.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}




