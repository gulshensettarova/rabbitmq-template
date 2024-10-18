package com.company.rabbitmq_demo.consumer;

import com.company.rabbitmq_demo.config.MessagingConfig;
import com.company.rabbitmq_demo.dto.EmailMessage;
import com.company.rabbitmq_demo.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailListener {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = MessagingConfig.MAIL_QUEUE)
    public void receiveMessage(EmailMessage emailMessage) {
        try {
            emailService.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getBody());
        } catch (Exception e) {
            // Xətanı loga yaz
            System.err.println("Error while sending email: " + e.getMessage());
        }
    }
}
