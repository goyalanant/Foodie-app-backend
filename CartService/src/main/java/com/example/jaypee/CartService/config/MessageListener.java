package com.example.jaypee.CartService.config;

import com.example.jaypee.CartService.domain.User;
import com.example.jaypee.CartService.repository.UserRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MessageListener {

    @Autowired
    private UserRepository userRepository;

    @RabbitListener(queues = MQConfig.QUEUE)
    public void listener(User message)
    {
        message.setUserId(UUID.randomUUID().toString());
        userRepository.save(message);
    }
}
