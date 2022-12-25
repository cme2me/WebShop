package com.gb.shop.service;


import com.example.api.validator.ProductValidator;
import com.gb.shop.dao.model.Basket;
import com.gb.shop.integration.ProductServiceIntegration;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BasketService {

    private final Basket basket;
    private final ProductValidator validator;
    private final ProductServiceIntegration productService;

    public BasketService(Basket basket, ProductValidator validator, ProductServiceIntegration productService) {
        this.basket = basket;
        this.validator = validator;
        this.productService = productService;
    }

    public void saveToBasket(UUID id) {
        if (basket.getSize() <= 10) {
            var product = productService.getProductDtoById(id).orElseThrow();

            validator.validate(product);

            basket.getProducts().add(product);
        }
    }

    //TODO потом сделать поиск по ID корзины
    public Basket getBasket() {
        return basket;
    }
}
