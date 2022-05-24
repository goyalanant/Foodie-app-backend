package com.example.jaypee.UserAuthenticationService.service;

import com.example.jaypee.UserAuthenticationService.domain.User;
import com.example.jaypee.UserAuthenticationService.exception.UserNotFoundException;
import com.example.jaypee.UserAuthenticationService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpli implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpli(UserRepository userRepository){
        this.userRepository=userRepository;
    }



    @Override
    public User saveUser(User user) {


        return userRepository.save(user);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws UserNotFoundException {

        User user = userRepository.findByEmailAndPassword(email, password);


        if(user == null)
        {
            throw new UserNotFoundException();
        }

        return user;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
