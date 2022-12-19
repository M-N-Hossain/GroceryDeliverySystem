package com.example.grocerydeliverysystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NonNull
    private int quantity;

    @ManyToOne
    private Product productID;

    @ManyToOne
    private Delivery deliveryID;

}
