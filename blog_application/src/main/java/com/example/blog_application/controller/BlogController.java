package com.example.blog_application.controller;

import com.example.blog_application.model.Blog;
import com.example.blog_application.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/blogs")
public class BlogController {
   @Autowired
    private IBlogService blogService;

    @GetMapping("")
   public String list(@RequestParam(name = "search",defaultValue = "")String search,Model model){
        model.addAttribute("blogList",blogService.searchBlog(search));
        return "/list";
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
