package com.example.blog_application.service.impl;

import com.example.blog_application.model.Category;
import com.example.blog_application.repository.ICategoryRepository;
import com.example.blog_application.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> showAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategory(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void createCategory(Category category) {

    }

    @Override
    public void deleteCategory(int id) {

    }

    @Override
    public void editCategory(int id) {

    }
}
