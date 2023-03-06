package com.example.blog_application.service;

import com.example.blog_application.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlogService {
    Page<Blog> showAll(Pageable pageable);

    Blog findBlog(int id);

    void createBlog(Blog blog);

    void deleteBlog(int id);

    void editBlog(Blog blog);

    Page<Blog> searchBlog(String title, Pageable pageable);

    List<Blog> sort(String title);
}
