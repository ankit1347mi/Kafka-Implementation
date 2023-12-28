package com.example.controller;

import com.example.dto.Customer;
import com.example.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/demo")
public class Controller {
    @Autowired
    private KafkaService service;

    @PostMapping
    public ResponseEntity<?> updateLocation(@RequestBody Customer demo) {
        service.sendEventsToTopic(demo);
        return new ResponseEntity<>(Map.of("message", demo), HttpStatus.OK);
    }
}
