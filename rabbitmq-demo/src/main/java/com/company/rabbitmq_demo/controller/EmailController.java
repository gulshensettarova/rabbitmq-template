package com.company.rabbitmq_demo.controller;

import com.company.rabbitmq_demo.dto.EmailMessage;
import com.company.rabbitmq_demo.producer.EmailProducer;
import com.company.rabbitmq_demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailProducer emailProducer;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailMessage emailMessage) {
        emailProducer.sendMailToQueue(emailMessage);
        return "Email is sent to the queue!";
    }
}
