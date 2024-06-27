package com.Appchara.co.APPchara.NotFoundException;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long Id){
        super("User could not found with " + Id);
    }

}
