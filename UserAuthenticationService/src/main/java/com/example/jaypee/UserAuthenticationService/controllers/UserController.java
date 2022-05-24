package com.example.jaypee.UserAuthenticationService.controllers;

import com.example.jaypee.UserAuthenticationService.config.MQConfig;
import com.example.jaypee.UserAuthenticationService.domain.User;
import com.example.jaypee.UserAuthenticationService.exception.UserAlreadyExistsException;
import com.example.jaypee.UserAuthenticationService.exception.UserNotFoundException;
import com.example.jaypee.UserAuthenticationService.service.ServiceTokenGenerator;
import com.example.jaypee.UserAuthenticationService.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin
public class UserController {

    private UserService userService;
    private ServiceTokenGenerator tokenGenerator;

    @Autowired
    private RabbitTemplate template;

    public ResponseEntity<?> responseEntity;

    @Autowired
    public UserController(UserService userService,ServiceTokenGenerator tokenGenerator){
        this.userService=userService;
        this.tokenGenerator=tokenGenerator;
    }


    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) throws UserAlreadyExistsException {
        template.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTING_KEY,user);
        Map<String,String> map = tokenGenerator.generateToken(user);
        userService.saveUser(user);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws UserNotFoundException
    {
        User user2 = userService.findByEmailAndPassword(user.getEmail(),user.getPassword());

        if(user2==null)
        {
            throw new UserNotFoundException();
        }
        Map<String,String> map = tokenGenerator.generateToken(user);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<?> getAllUser(@RequestBody User user) throws UserNotFoundException {
        return new ResponseEntity<List<User>>(userService.getAllUser(),HttpStatus.OK);

    }

}
