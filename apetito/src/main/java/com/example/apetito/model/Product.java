package com.example.apetito.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productID;
    @Column
    private String name;
    @Column
    private Double prize;
    @Column
    private String photoUrl;
    @JoinColumn
    @ManyToOne (fetch = FetchType.EAGER)
    private Restaurant restaurant;
    @JoinColumn
    @ManyToOne (fetch = FetchType.EAGER)
    private DishType dishType;
}
