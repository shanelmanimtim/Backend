package com.Appchara.co.APPchara.NotFoundException;

public class OrderItemNotFoundException extends RuntimeException {
    public OrderItemNotFoundException(Long Id){
        super("User could not found with " + Id);
    }

}

