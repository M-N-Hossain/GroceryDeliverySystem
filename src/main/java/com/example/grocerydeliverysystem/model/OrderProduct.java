package com.example.grocerydeliverysystem.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private double quantity;
    @NonNull
    private double totalPrice;
    @NonNull
    private double totalWeight;


//    @NonNull
//    private long productID;
//    @NonNull
//    private long deliverID;


    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @Nullable
    private Product productID;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JoinColumn(name = "delivery_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @Nullable
    private DeliveryInfo deliveryInfoID;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JoinColumn(name = "delivery_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    @Nullable
    private Van vanID;



    public OrderProduct(long id, @NonNull long quantity, @NonNull long totalPrice, @NonNull long totalWeight, Product productID, DeliveryInfo deliveryInfoID, Van vanID) {
        this.id = id;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.totalWeight = totalWeight;
        this.productID = productID;
        this.deliveryInfoID = deliveryInfoID;
        this.vanID = vanID;
    }
}
