package com.example.blog_jquery.dto;
import com.example.blog_jquery.model.Blog;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Set;

public class CategoryDTO {
    private Integer id;
    private String name;
    @JsonManagedReference
    private Set<BlogDTO> blogSet;

    public CategoryDTO() {
    }

    public CategoryDTO(Integer id, String name, Set<BlogDTO> blogSet) {
        this.id = id;
        this.name = name;
        this.blogSet = blogSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BlogDTO> getBlogSet() {
        return blogSet;
    }

    public void setBlogSet(Set<BlogDTO> blogSet) {
        this.blogSet = blogSet;
    }
}
