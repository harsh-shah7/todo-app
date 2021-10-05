package com.nc.todo.service;

import com.nc.todo.dto.TodoDto;
import com.nc.todo.entity.Todo;
import com.nc.todo.exception.TodoNotFoundException;
import com.nc.todo.pojo.TodoFilterDto;

import java.util.List;


public interface TodoService {

    public TodoDto getTodoById(Long id) throws TodoNotFoundException;
    public List<TodoDto> getAllTodosByFilterParams(Long userId,String filterParam);
    public TodoDto createTodo(Todo todo);
    public TodoDto updateTodo(Long id,Todo todo) throws TodoNotFoundException ;

}
