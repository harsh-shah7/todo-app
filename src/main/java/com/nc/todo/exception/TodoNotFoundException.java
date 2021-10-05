package com.nc.todo.exception;

public class TodoNotFoundException extends Exception {

    public TodoNotFoundException() {
        super("No todo found associated with given Id");
    }

    public TodoNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
