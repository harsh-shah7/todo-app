package com.nc.todo.serviceimpl;

import com.nc.todo.entity.Category;
import com.nc.todo.repository.CategoryRepository;
import com.nc.todo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public Optional<Category> getCategory(Long id){
        return categoryRepository.findById(id);
    }
    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }
}
