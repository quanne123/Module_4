package com.example.blog_application.repository;

import com.example.blog_application.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {

//    List<Blog> findBlogByTitleContaining(String search);
    @Query(value = "select * from Blog where title like %:freeText%", nativeQuery = true)
    Page<Blog> searchTitleFreeStyle(@Param("freeText") String name, Pageable pageable);


}
