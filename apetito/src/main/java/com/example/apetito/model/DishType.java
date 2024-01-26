package com.example.apetito.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DishType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dishTypeID;
    @Column
    private String name;
    @Column
    private String photoUrl;
}
