package com.example.grocerydeliverysystem.repositories;

import com.example.grocerydeliverysystem.model.Van;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VanRepo extends JpaRepository<Van, Integer> {
}