package com.example.login.service;

import com.example.login.entity.User;
import com.example.login.entity.Users;

import java.util.List;

public interface UserService {

    String addUser(User user);
    String getUser(User user);

    List<String> getAllUsers();
}
