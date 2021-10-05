package com.nc.todo.dto;

import com.nc.todo.entity.Gender;
import com.nc.todo.entity.Todo;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String mobileNum;

    private Gender gender;

    private Date birthdate;
}
