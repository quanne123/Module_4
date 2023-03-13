package com.example.blog_jquery.service;

import com.example.blog_jquery.dto.BlogDTO;
import com.example.blog_jquery.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<BlogDTO> findTittle(String tittle, Pageable pageable);
    BlogDTO findById(int id);
}