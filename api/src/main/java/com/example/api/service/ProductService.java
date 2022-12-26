package com.example.api.service;

import com.example.api.dao.ProductRepository;
import com.example.api.dao.entity.Product;
import com.example.api.dto.ProductDto;
import com.example.api.exception.ProductException;
import com.example.api.mapper.ProductMapper;
import com.example.api.validator.ProductValidator;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final ProductValidator validator;


    public ProductService(ProductRepository repository, ProductMapper mapper, ProductValidator validator) {
        this.repository = repository;
        this.mapper = mapper;
        this.validator = validator;
    }

    public ProductDto findById(UUID id) {
        return mapper.toProductDto(repository.findById(id).orElseThrow());
    }

    public void deleteById(UUID id) {
        if (Objects.isNull(id)) {
            throw new ProductException("Id not presented");
        }
        repository.deleteById(id);
    }

    public void saveProduct(String name, Double price) {
        Product product = new Product();
        product.setId(UUID.randomUUID());
        product.setPrice(price);
        product.setName(name);

        validator.validate(product);

        repository.save(product);
    }

    public List<ProductDto> findAll() {
        return mapper.toProductDtoList(repository.findAll());
    }

    public void updateProduct(UUID id, String newName, Double newPrice) {
        Product product = repository.findById(id).orElse(new Product(id, newName, newPrice));

        validator.validate(product);

        repository.save(product);
    }
}
