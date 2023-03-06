package com.example.blog_application.controller;

import com.example.blog_application.model.Blog;
import com.example.blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
   @Autowired
    private IBlogService blogService;

   @GetMapping("")
   public String getBlogs(Model model,
                          @RequestParam(name = "title",required = false)String title,
                          @PageableDefault(size = 3)Pageable pageable){
       Page<Blog> blogs = title == null
               ? this.blogService.showAll(pageable)
               : this.blogService.searchBlog(title,pageable);
       model.addAttribute("blogs",blogs);
       model.addAttribute("freeText",title);
       List<Integer> integers = new ArrayList<>();
       for (int i = 0; i < blogs.getTotalPages() ; i++) {
           integers.add(i);
       }
       model.addAttribute("pages",integers);
       return "list";
   }
    @GetMapping("/showCreate")
    public String showCreate(Model model){
        model.addAttribute("blog",new Blog());
        return "/create";
    }

    @PostMapping("/createBlog")
    public String createBlog(@ModelAttribute(name = "newBlog") Blog newBlog){
        blogService.createBlog(newBlog);
        return "redirect:/blogs";
    }
    @GetMapping("/inform/{id}")
    public String getInform(@PathVariable int id, Model model) {
        model.addAttribute("blogInform", blogService.findBlog(id));
        return "/information";
    }

    @GetMapping("/deleteBlog/{id}")
    public String deleteBlog(@PathVariable int id) {
        blogService.deleteBlog(id);
        return "redirect:/blogs";
    }

    @GetMapping("/showEdit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findBlog(id));
        return "/edit";
    }

    @PostMapping("/editBlog")
    public String editBlog(@ModelAttribute(name = "blog") Blog blog, Model model) {
        blogService.editBlog(blog);
        return "redirect:/blogs";
    }
}
