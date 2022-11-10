package com.gb.shop.service;

import com.gb.shop.dao.ProductRepository;
import com.gb.shop.dao.entity.Product;
import com.gb.shop.dto.ProductDto;
import com.gb.shop.exceptions.ProductException;
import com.gb.shop.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;
    public ProductService(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
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
        repository.save(product);
    }

    public List<ProductDto> findAll() {
        return mapper.toProductDtoList(repository.findAll());
    }

    public void updateProduct(UUID id, String newName, Double newPrice) {
        Product product = repository.findById(id).orElseThrow();
        product.setName(newName);
        product.setPrice(newPrice);
        repository.save(product);
    }
}
