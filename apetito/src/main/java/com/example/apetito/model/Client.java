package com.example.apetito.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientID;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private int phoneNumber;
    @Column
    private String password;
}
