package com.gb.shop.exceptions;

public class ProductException extends RuntimeException {
    private String message;

    public ProductException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
