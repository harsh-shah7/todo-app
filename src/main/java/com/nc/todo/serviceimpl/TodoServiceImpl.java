package com.nc.todo.serviceimpl;

import com.nc.todo.builder.TodoSpecificationBuilder;
import com.nc.todo.dto.TodoDto;
import com.nc.todo.entity.Todo;
import com.nc.todo.exception.TodoNotFoundException;
import com.nc.todo.pojo.SearchCriteria;
import com.nc.todo.pojo.TodoFilterDto;
import com.nc.todo.repository.TodoRepository;
import com.nc.todo.service.TodoService;
import com.nc.todo.specification.TodoSpecification;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoRepository todoRepository;

    public TodoDto getTodoById(Long id) throws TodoNotFoundException {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if(optionalTodo.isPresent()){
            return prepareTodoDto(optionalTodo.get());
        }else{
            throw new TodoNotFoundException();
        }
    }

    public List<TodoDto> getAllTodosByFilterParams(Long userId,String filterParams) {
        TodoSpecificationBuilder builder = new TodoSpecificationBuilder();
        builder.with("userId", ":", userId);
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(filterParams + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        Specification<Todo> spec = builder.build();

        List<Todo> todos = todoRepository.findAll(spec);
        return todos.stream().map(todo -> prepareTodoDto(todo)).collect(Collectors.toList());
    }


    private TodoDto prepareTodoDto(Todo todo){
        TodoDto todoDto = new TodoDto();
        BeanUtils.copyProperties(todo,todoDto);
        return todoDto;
    }

    public TodoDto createTodo(Todo todo){
        return prepareTodoDto(todoRepository.save(todo));
    }

    public TodoDto updateTodo(Long id,Todo todo) throws TodoNotFoundException {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if(optionalTodo.isPresent()) {
            return prepareTodoDto(todoRepository.save(todo));
        }else{
            throw new TodoNotFoundException();
        }
    }
}
