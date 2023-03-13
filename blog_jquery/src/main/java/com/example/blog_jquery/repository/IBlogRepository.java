package com.example.blog_jquery.repository;

import com.example.blog_jquery.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Page<Blog> findByTittleContaining(String tittle, Pageable pageable);
}
