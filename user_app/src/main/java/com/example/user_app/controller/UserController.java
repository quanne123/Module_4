package com.example.user_app.controller;

import com.example.user_app.model.User;
import com.example.user_app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("")
    private String showUserList(Model model){
        model.addAttribute("userList", userService.findAll());
        return "list";
    }
    @GetMapping("/showCreate")
    private String showFormCreate(Model model){
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/validate")
    private String validateUser(@Validated @ModelAttribute User user, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            return "create";
        }else {
            userService.createUser(user);
            return "redirect:/users";
        }
    }
}
