package com.gb.shop.service;

import com.gb.shop.dao.ProductRepository;
import com.gb.shop.dao.model.Basket;
import com.gb.shop.validator.ProductValidator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BasketService {

    private final ProductRepository productRepository;
    private final Basket basket;
    private final ProductValidator validator;

    public BasketService(ProductRepository productRepository, Basket basket, ProductValidator validator) {
        this.productRepository = productRepository;
        this.basket = basket;
        this.validator = validator;
    }

    public void saveToBasket(UUID id) {
        if (basket.getSize() <= 10) {
            var product = productRepository.findById(id).orElseThrow();

            validator.validate(product);

            basket.getProducts().add(product);
        }
    }
    //TODO потом сделать поиск по ID корзины
    public Basket getBasket() {
        return basket;
    }
}
