package com.example.grocerydeliverysystem.repositories;

import com.example.grocerydeliverysystem.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepo extends JpaRepository<Delivery, Integer> {
}
