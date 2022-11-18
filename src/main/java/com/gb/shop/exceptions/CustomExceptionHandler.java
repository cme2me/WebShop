package com.gb.shop.exceptions;

import com.gb.shop.dto.ResponseMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ResponseMessage> productException(ProductException e) {
        return ResponseEntity.badRequest().body(new ResponseMessage(e.getMessage()));
    }
    @ExceptionHandler(ValidateException.class)
    public ResponseEntity<ResponseMessage> validateException(ValidateException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(e.getMessage()));
    }
}
