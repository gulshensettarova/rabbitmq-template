package com.company.rabbitmq_demo.producer;

import com.company.rabbitmq_demo.config.MessagingConfig;
import com.company.rabbitmq_demo.dto.EmailMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailProducer {
   @Autowired
   private RabbitTemplate rabbitTemplate;
   public void sendMailToQueue(EmailMessage message) {
    rabbitTemplate.convertAndSend(MessagingConfig.MAIL_EXCHANGE,MessagingConfig.MAIL_ROUTING_KEY,message);
   }
}
