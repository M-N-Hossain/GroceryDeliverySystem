package com.example.grocerydeliverysystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@AllArgsConstructor
@ToString
public class DeliveryInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private LocalDate deliveryDate;
    @NonNull
    private String fromWarehouse;
    @NonNull
    private String destination;

//    @OneToMany()
//    @JoinColumn(name = "deliver_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
//    private List<OrderProduct> orderProducts;
    public DeliveryInfo() {
    }
}
