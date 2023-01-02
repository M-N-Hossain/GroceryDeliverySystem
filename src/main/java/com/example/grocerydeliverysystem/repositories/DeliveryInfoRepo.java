package com.example.grocerydeliverysystem.repositories;

import com.example.grocerydeliverysystem.model.DeliveryInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryInfoRepo extends JpaRepository<DeliveryInfo, Integer> {
}
