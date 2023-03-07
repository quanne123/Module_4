package com.example.user_app.service;

import com.example.user_app.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void createUser(User user);
}
