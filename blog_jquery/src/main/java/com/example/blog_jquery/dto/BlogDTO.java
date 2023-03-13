package com.example.blog_jquery.dto;

import com.example.blog_jquery.model.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;

public class BlogDTO {
    private Integer id;
    private String tittle;
    private String content;
    private String img;
    @JsonBackReference
    private CategoryDTO categoryDTO;

    public BlogDTO() {
    }

    public BlogDTO(Integer id, String tittle, String content, CategoryDTO categoryDTO) {
        this.id = id;
        this.tittle = tittle;
        this.content = content;
        this.categoryDTO = categoryDTO;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
