package com.example.grocerydeliverysystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@ToString
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private LocalDate deliveryDate;
    @NonNull
    private String fromWarehouse;
    @NonNull
    private String destination;

//    @OneToMany(mappedBy = "delivery")
//    private List<ProductOrder> productOrders;

    public Delivery() {
    }
}
