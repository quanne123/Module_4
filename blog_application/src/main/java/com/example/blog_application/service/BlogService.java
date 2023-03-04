package com.example.blog_application.service;

import com.example.blog_application.model.Blog;
import com.example.blog_application.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public List<Blog> showAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public Blog findBlog(int id) {
        return blogRepository.getById(id);
    }

    @Override
    public void createBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void deleteBlog(int id) {
        blogRepository.delete(findBlog(id));
    }

    @Override
    public void editBlog(Blog blog) {
        blogRepository.save(blog);
    }

    public List<Blog> searchBlog(String search) {
        return blogRepository.findBlogByTitleContaining(search);
    }
}
