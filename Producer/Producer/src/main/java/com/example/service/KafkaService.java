package com.example.service;

import com.example.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaService {

    private KafkaTemplate<String, Customer> kafkaTemplate;

    @Autowired
    public KafkaService(KafkaTemplate<String, Customer> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendEventsToTopic(Customer demo) {
        CompletableFuture<SendResult<String, Customer>> future = kafkaTemplate.send("demo-topic", demo);

    }
}
