package ru.itmentor.spring.boot_security.demo.util;

public class UserNotCreatingException extends RuntimeException {


    public UserNotCreatingException (String msg){
        super(msg);
    }
}
