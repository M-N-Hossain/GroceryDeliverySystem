package com.example.grocerydeliverysystem.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.action.internal.OrphanRemovalAction;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
@JsonDeserialize(as = OrderProduct.class)
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private long quantity;
    @NonNull
    private long totalPrice;

    public OrderProduct() {

    }

//    @ManyToOne(fetch = FetchType.LAZY)
//    @Nullable
//    private Product productID;


    //
//    @ManyToOne(fetch = FetchType.LAZY)
//    @Nullable
//    private Delivery deliveryID;

}
