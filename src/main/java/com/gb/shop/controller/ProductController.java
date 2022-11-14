package com.gb.shop.controller;

import com.gb.shop.dto.ProductDto;
import com.gb.shop.dto.ResponseMessage;
import com.gb.shop.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @Operation(summary = "Возврат продукта по ID", description = "Необходимо указать ID продукта")
    @GetMapping("/show/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @Operation(summary = "Удаление продукта", description = "Необходимо указать ID продукта, который хотим удалить")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseMessage> deleteById(@PathVariable UUID id) {
        service.deleteById(id);
        var product = service.findById(id);
        return ResponseEntity.ok().body(new ResponseMessage("Товар " + product.getName() + " удалён"));
    }

    @Operation(summary = "Получение всех продуктов")
    @GetMapping("/findAll")
    public ResponseEntity<List<ProductDto>> findAllProducts() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @Operation(summary = "Сохранение продуктов", description = "Необходимо указать название и цену продукта ")
    @PostMapping("/save")
    public ResponseEntity<ResponseMessage> saveProduct(@RequestParam("name") String name,
                                                       @RequestParam("price") Double price) {
        service.saveProduct(name, price);
        return ResponseEntity.ok().body(new ResponseMessage("Товар " + name + "успешно сохранен"));
    }

    @Operation(summary = "Обновление данных о продукте", description = "Необходимо указать id, который ходим обновить, новые названия и цены продукта")
    @PatchMapping("/update")
    @Transactional
    public ResponseEntity<ResponseMessage> updateProduct(@RequestParam("name") String name,
                                                         @RequestParam("price") Double price,
                                                         @RequestParam("id") UUID id) {
        service.updateProduct(id,name, price);
        return ResponseEntity.ok().body(new ResponseMessage("Товар " + name + "успешно сохранен"));
    }
}
