package com.nc.todo.exception;

public class UserNotFoundException extends Exception{

    public UserNotFoundException() {
        super("No User found associated with given Id");
    }

    public UserNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
