package com.example.grocerydeliverysystem.service;

import com.example.grocerydeliverysystem.model.Product;
import com.example.grocerydeliverysystem.repositories.ProductRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    ProductService productService;
    @Autowired
    ProductRepo productRepo;

    Product product;

//    @BeforeEach
//    void setUp() {
//        productRepo.deleteAll();
//        product = new Product(1,"Milk",1000,13);
//
//    }
//
//    @Test
//    void getListOfProduct() {
//        productRepo.save(product);
//        assertEquals(1, productService.getListOfProduct().size());
//    }
//
//    @Test
//    void addProduct() {
//        productService.addProduct(product);
//        assertEquals(productRepo.findById(1L).get().getName(), product.getName());
//    }
//
//    @Test
//    void updateProduct() {
//        productRepo.save(product);
//        String name = "Honey";
//
//        productService.updateProduct(product.getId(), new Product(1,name, 1000,1000));
//        assertEquals(productRepo.findById(1L).get().getName(), name);
//    }
//
//    @Test
//    void deleteProduct() {
//        productRepo.save(product);
//
//        productService.deleteProduct(product.getId());
//        assertTrue(productRepo.findById(product.getId()).isEmpty());
//    }
//
//    @Test
//    void getProductByName() {
//        productRepo.save(product);
//        assertEquals(productRepo.findById(product.getId()).get().getName(), productService.getProductByName("Milk").getName());
//    }
}