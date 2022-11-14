package com.gb.shop.dao.model;

import com.gb.shop.dao.entity.BaseProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Basket {
    private UUID id;
    private Integer size;
    private List<? super BaseProduct> products;
}
