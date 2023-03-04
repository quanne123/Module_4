package com.example.blog_application.service;

import com.example.blog_application.model.Blog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBlogService {
    List<Blog> showAll();

    Blog findBlog(int id);

    void createBlog(Blog blog);

    void deleteBlog(int id);

    void editBlog(Blog blog);

    List<Blog> searchBlog(String search);
}
