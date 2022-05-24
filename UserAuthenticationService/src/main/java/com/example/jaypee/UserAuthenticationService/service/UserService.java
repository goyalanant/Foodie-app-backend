package com.example.jaypee.UserAuthenticationService.service;

import com.example.jaypee.UserAuthenticationService.domain.User;
import com.example.jaypee.UserAuthenticationService.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

    public User saveUser(User user);
    public User findByEmailAndPassword(String email,String password) throws UserNotFoundException;
    public List<User> getAllUser();
}
