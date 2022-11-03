package com.gb.shop.service;

import com.gb.shop.dao.ProductRepository;
import com.gb.shop.dto.ProductDto;
import com.gb.shop.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import java.util.List;
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
        repository.deleteById(id);
    }

    public void saveProduct(ProductDto productDto) {

        repository.save(mapper.toProductEntity(productDto));
    }

    public List<ProductDto> findAll() {
        return mapper.toProductDtoList(repository.findAll());
    }
}
