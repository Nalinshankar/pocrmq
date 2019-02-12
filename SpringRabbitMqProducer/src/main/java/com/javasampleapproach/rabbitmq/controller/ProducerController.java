package com.javasampleapproach.rabbitmq.controller;

import com.javasampleapproach.rabbitmq.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private Producer messageProducer;


    @GetMapping
    public String produce(@RequestParam String message) {

        messageProducer.sendMessage(message);
        return "Message Sent to rabbitMQ and message="+message;
    }



}

