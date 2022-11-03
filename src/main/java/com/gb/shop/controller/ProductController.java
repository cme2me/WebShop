package com.gb.shop.controller;

import com.gb.shop.dto.ProductDto;
import com.gb.shop.dto.ResponseMessage;
import com.gb.shop.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<ProductDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseMessage> deleteById(@PathVariable UUID id) {
        service.deleteById(id);
        var product = service.findById(id);
        return ResponseEntity.ok().body(new ResponseMessage("Товар " + product.getName() + " удалён"));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<ProductDto>> findAllProducts() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseMessage> saveProduct(@RequestParam("title") String name,
                                                       @RequestParam("price") Double price) {
        service.saveProduct(name, price);
        return ResponseEntity.ok().body(new ResponseMessage("Товар " + name + "успешно сохранен"));
    }
}
