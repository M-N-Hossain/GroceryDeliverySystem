package com.example.grocerydeliverysystem.repositories;

import com.example.grocerydeliverysystem.model.Delivery;
import com.example.grocerydeliverysystem.model.OrderProduct;
import com.example.grocerydeliverysystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderProductRepo extends JpaRepository<OrderProduct, Integer> {


//    long deleteByProductID(Product productID);
}
