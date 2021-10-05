package com.nc.todo.controller;


import com.nc.todo.entity.Todo;
import com.nc.todo.exception.TodoNotFoundException;
import com.nc.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/users/{userId}/todos")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getTodo(@PathVariable Long userId, @PathVariable Long id){
        try{
            return new ResponseEntity<>(todoService.getTodoById(id), HttpStatus.OK);
        }catch(TodoNotFoundException e){
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<?> getAllTodosByFilterCiteria(@PathVariable Long userId,@RequestParam(required = false) String search){
        //sample url- http://localhost:8080/api/users/1/todos?search=id:1;
        return new ResponseEntity<>(todoService.getAllTodosByFilterParams(userId,search), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody Todo todo){
        return new ResponseEntity(todoService.createTodo(todo),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable Long id,@RequestBody Todo todo){
        try{
            return new ResponseEntity(todoService.updateTodo(id,todo),HttpStatus.OK);
        }catch(TodoNotFoundException e){
            return new ResponseEntity<>(e,HttpStatus.NOT_FOUND);
        }
    }
}
