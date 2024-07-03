package com.Appchara.co.APPchara.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Appchara.co.APPchara.NotFoundException.OrderItemNotFoundException;

@RestControllerAdvice
public class OrderItemExceptionHandler {
    
    @ExceptionHandler(OrderItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String OrderExceptionHandler(OrderItemNotFoundException e){
        return e.getMessage();
    }
}