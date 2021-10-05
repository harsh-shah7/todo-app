package com.nc.todo.pojo;

import lombok.*;

@Data
@AllArgsConstructor
public class SearchCriteria {
    private String key;
    private String operation;
    private Object value;
}
