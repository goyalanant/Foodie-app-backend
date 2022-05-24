package com.example.jaypee.UserAuthenticationService.service;

import com.example.jaypee.UserAuthenticationService.domain.User;

import java.util.Map;


public interface ServiceTokenGenerator {

    Map<String,String> generateToken(User user);
}
