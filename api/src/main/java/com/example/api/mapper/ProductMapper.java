package com.example.api.mapper;

import com.example.api.dao.entity.Product;
import com.example.api.dto.ProductDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface ProductMapper {
    ProductDto toProductDto(Product product);
    List<ProductDto> toProductDtoList(List<Product> productEntities);
    Product toProductEntity(ProductDto dto);
}
