package com.nc.todo.dto;

import com.nc.todo.entity.Category;
import com.nc.todo.entity.Status;
import lombok.Data;

import java.util.Date;

@Data
public class TodoDto {

    private Long id;

    private String name;

    private String description;

    private Date timestamp;

    private Category category;

    private Status status;
}
