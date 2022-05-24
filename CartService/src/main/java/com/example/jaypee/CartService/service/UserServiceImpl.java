package com.example.jaypee.CartService.service;

import com.example.jaypee.CartService.domain.User;
import com.example.jaypee.CartService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public User getUserByEmail(String email) {



        return  userRepository.getUserByEmail(email);
    }
}
