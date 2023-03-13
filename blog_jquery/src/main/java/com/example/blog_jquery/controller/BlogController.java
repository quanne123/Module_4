package com.example.blog_jquery.controller;

import com.example.blog_jquery.dto.BlogDTO;
import com.example.blog_jquery.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Page<BlogDTO> blogDTOS(@PageableDefault(size = 3) Pageable pageable,
                                  @RequestParam(name = "tittle",required = false,defaultValue = "") String tittle
    ){
        return iBlogService.findTittle(tittle, pageable);
    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/detail")
    public BlogDTO detail(@RequestParam(required = false) Integer id) {
        return iBlogService.findById(id);
    }
}