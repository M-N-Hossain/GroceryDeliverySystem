package com.example.grocerydeliverysystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    @NonNull
    private double price;
    @NonNull
    private double weight;

//    @OneToMany(mappedBy = "product")
//    private List<ProductOrder> productOrders;

    public Product(int id, @NonNull String name, @NonNull double price, @NonNull double weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.weight = weight;
    }

    public Product(){}

}
