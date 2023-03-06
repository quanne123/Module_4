package com.example.blog_application.service;

import com.example.blog_application.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> showAll();

    Category findCategory(int id);

    void createCategory(Category category);

    void deleteCategory(int id);

    void editCategory(int id);


}
