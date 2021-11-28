package com.bmiapi.core.user.exception;

public class InvalidUserException extends RuntimeException{
    public InvalidUserException(String msg) {
        super(msg);
    }
}
