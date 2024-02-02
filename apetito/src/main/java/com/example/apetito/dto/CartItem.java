package com.example.apetito.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {
    private Long id;
    private Integer quantity;
    private String name;   // Dodane do przechowywania nazwy produktu
    private Double price;  // Dodane do przechowywania ceny produktu
}
