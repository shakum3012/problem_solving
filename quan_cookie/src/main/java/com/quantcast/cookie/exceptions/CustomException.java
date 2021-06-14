package com.quantcast.cookie.exceptions;

public class CustomException extends RuntimeException{

    private String message;

    public CustomException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
