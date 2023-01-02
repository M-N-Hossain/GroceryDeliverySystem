package com.example.grocerydeliverysystem.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@AllArgsConstructor
public class Van {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String vanName;
    private int capacity;

    public Van() {

    }
}
