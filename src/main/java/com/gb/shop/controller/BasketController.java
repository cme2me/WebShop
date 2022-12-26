package com.gb.shop.controller;

import com.example.api.dao.entity.BaseProduct;
import com.gb.shop.dto.ResponseMessage;
import com.gb.shop.service.BasketService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.UUID;

@Controller
public class BasketController {
    @Autowired
    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @Operation(summary = "Сохранение продуктов в корзину", description = "Необходимо указать ID продукта, который хотим сохранить в корзину")
    @PostMapping("/save/to/basket/{id}")
    public ResponseEntity<ResponseMessage> saveProductToBasket(@PathVariable UUID id) {
        basketService.saveToBasket(id);
        return ResponseEntity.ok().body(new ResponseMessage("Товар сохранен в корзину"));
    }

    //TODO добавить поиск корзин по ID
    @Operation(summary = "Получение списка продуктов из корзины")
    @GetMapping("/get/basket/products")
    public ResponseEntity<List<? super BaseProduct>> getBasket() {
        return ResponseEntity.ok().body(basketService.getBasket().getProducts());
    }
}
