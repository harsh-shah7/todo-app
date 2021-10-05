package com.nc.todo.entity;

import java.util.stream.Stream;

public enum Status {

    Initial("I"),
    Started("S"),
    Completed("C"),
    Snoozed("N"),
    Overdue("O");

    private String status;

    private Status(String status) {
        this.status = status;
    }

    public String getCode() {
        return status;
    }
}
