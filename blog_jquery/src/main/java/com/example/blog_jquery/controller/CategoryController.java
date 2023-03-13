package com.example.blog_jquery.controller;

import com.example.blog_jquery.dto.CategoryDTO;
import com.example.blog_jquery.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Page<CategoryDTO> showListCategory(Pageable pageable) {
        return iCategoryService.findAll(pageable);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detail")
    public CategoryDTO getCategory (@RequestParam(required = false) Integer id) {
        return iCategoryService.findById(id);
    }
}