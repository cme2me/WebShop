package com.gb.shop.validator;

import com.gb.shop.dao.entity.Product;
import com.gb.shop.dto.ProductDto;
import com.gb.shop.exceptions.ValidateException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Component
public class ProductValidator {
    private final List<String> errorList = new ArrayList<>();
    public void validate(ProductDto dto) {
        if (Objects.isNull(dto.getName())) {
            errorList.add("Product name not presented");
        }
        if (Objects.isNull(dto.getPrice()) || dto.getPrice() <= 0) {
            errorList.add("Product price is null or <= 0");
        }
        if (!errorList.isEmpty()) {
            throw new ValidateException(errorList);
        }
    }
    public void validate(Product product) {
        if (Objects.isNull(product.getName())) {
            errorList.add("Product name not presented");
        }
        if (Objects.isNull(product.getPrice()) || product.getPrice() <= 0) {
            errorList.add("Product price is null or <= 0");
        }
        if (!errorList.isEmpty()) {
            throw new ValidateException(errorList);
        }
    }
}
