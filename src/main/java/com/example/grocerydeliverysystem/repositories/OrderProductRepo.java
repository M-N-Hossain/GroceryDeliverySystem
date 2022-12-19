package com.example.grocerydeliverysystem.repositories;

import com.example.grocerydeliverysystem.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepo extends JpaRepository<OrderProduct, Integer> {
}
