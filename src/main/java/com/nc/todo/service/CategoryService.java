package com.nc.todo.service;

import com.nc.todo.entity.Category;

import java.util.Optional;


public interface CategoryService {

    public Optional<Category> getCategory(Long id);
    public void createCategory(Category category);
    public void deleteCategory(Long id);
}
