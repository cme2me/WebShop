package com.gb.shop.dao.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product extends BaseProduct{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private UUID id;
    private String name;
    private Double price;
}
