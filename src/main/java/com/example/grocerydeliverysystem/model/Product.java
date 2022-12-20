package com.example.grocerydeliverysystem.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String name;
    @NonNull
    private double weight;
    @NonNull
    private double price;


//    @OneToMany(cascade = CascadeType.ALL)
//    private List<OrderProduct> orderProducts;


    public Product(){}

}
