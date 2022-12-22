package com.gb.shop.integration;

import com.example.api.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ProductServiceIntegration {
    private final RestTemplate productServiceTemplate;

    public Optional<ProductDto> getProductDtoById(UUID id) {
        return Optional.ofNullable(productServiceTemplate.getForObject("http://localhost:8080/show/" + id, ProductDto.class));
    }

}
