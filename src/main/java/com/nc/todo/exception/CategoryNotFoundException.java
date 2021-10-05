package com.nc.todo.exception;

public class CategoryNotFoundException extends Exception {

    public CategoryNotFoundException() {
        super("No category found associated with given Id");
    }

    public CategoryNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
