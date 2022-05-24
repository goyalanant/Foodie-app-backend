package com.example.jaypee.CartService.service;

import com.example.jaypee.CartService.domain.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public User getUserByEmail(String email);
}
