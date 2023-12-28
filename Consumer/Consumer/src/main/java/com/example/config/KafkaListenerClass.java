package com.example.config;


import com.example.dto.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



@Service
public class KafkaListenerClass {

    Logger log= LoggerFactory.getLogger(KafkaListenerClass.class);
    @org.springframework.kafka.annotation.KafkaListener(topics = "demo-topic", groupId = "demo1")
    public void updatedLocation(Customer demo) {
        log.info("Consumed data {}",demo.toString());
    }
}
