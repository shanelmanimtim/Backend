package com.Appchara.co.APPchara.ExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.Appchara.co.APPchara.NotFoundException.OrderNotFoundException;

@RestControllerAdvice
public class OrderExceptionHandler {
    
    @ExceptionHandler(OrderNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String UserExceptionHandle(OrderNotFoundException e){
        return e.getMessage();
    }
}
