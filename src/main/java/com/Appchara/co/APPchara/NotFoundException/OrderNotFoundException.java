package com.Appchara.co.APPchara.NotFoundException;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long Id){
        super("User could not found with " + Id);
    }

}

