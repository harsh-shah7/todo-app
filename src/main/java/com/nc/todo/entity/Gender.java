package com.nc.todo.entity;

public enum Gender {
    Male("M"),
    Female("F"),
    Other("O");

    private String gender;

    private Gender(String gender) {
        this.gender = gender;
    }

    public String getCode() {
        return gender;
    }
}
