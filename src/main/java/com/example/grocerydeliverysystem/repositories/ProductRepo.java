package com.example.grocerydeliverysystem.repositories;

import com.example.grocerydeliverysystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product, Long> {

    Product getProductsByName(String name);
}
