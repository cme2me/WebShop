package com.gb.shop.config;

import com.gb.shop.dao.model.Basket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.UUID;

@Configuration
public class BasketConfig {
    @Bean(value = "singleton")
    public Basket createBasket() {
        return new Basket(UUID.randomUUID(), 10, new ArrayList<>());
    }
}
