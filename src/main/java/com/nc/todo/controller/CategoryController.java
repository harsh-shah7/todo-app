package com.nc.todo.controller;

import com.nc.todo.entity.Category;
import com.nc.todo.exception.CategoryNotFoundException;
import com.nc.todo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategory(@PathVariable Long id){
        Optional<Category> optionalCategory = categoryService.getCategory(id);
        if(optionalCategory.isPresent())
            return new ResponseEntity<>(optionalCategory.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(new CategoryNotFoundException(),HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> createCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
