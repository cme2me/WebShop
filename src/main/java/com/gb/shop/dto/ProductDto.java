package com.gb.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private UUID id;
    private String name;
    private Double price;

    public ProductDto(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
