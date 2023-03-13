package com.example.blog_jquery.repository;

import com.example.blog_jquery.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
        Category findById(int id);
}
