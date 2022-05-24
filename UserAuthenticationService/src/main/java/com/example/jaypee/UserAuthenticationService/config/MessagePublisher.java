package com.example.jaypee.UserAuthenticationService.config;

import com.example.jaypee.UserAuthenticationService.domain.User;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MessagePublisher {

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody User message)
    {
//        message.setMessageId(UUID.randomUUID().toString());
//        message.setMessageDate(new Date());
        template.convertAndSend(MQConfig.EXCHANGE,MQConfig.ROUTING_KEY,message);
        return "Message Published";
    }


}
