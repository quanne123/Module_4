package com.example.blog_jquery.service;

import com.example.blog_jquery.dto.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Page<CategoryDTO> findAll(Pageable pageable);
    CategoryDTO findById(int id);
}