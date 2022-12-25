package com.example.api.exception;

import java.util.List;

public class ValidateException extends RuntimeException {

    public ValidateException(List<String> messages) {
        super(String.join(",", messages));
    }
}
