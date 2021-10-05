package com.nc.todo.pojo;

import lombok.Getter;

import java.util.List;

@Getter
public class TodoFilterDto {
    List<SearchCriteria> searchCriterias;
}
