package com.company.rabbitmq_demo.dto;

import lombok.Data;

@Data
public class EmailMessage {
    private String to;
    private String subject;
    private String body;
}
