package com.example.blog_application.service.impl;

import com.example.blog_application.model.Blog;
import com.example.blog_application.repository.IBlogRepository;
import com.example.blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public Page<Blog> showAll(Pageable pageable) {
        return this.blogRepository.findAll(pageable);
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

    @Override
    public Page<Blog> searchBlog(String title, Pageable pageable) {
        return blogRepository.searchTitleFreeStyle(title,pageable);
    }

    @Override
    public List<Blog> sort(String title) {

    }

}
