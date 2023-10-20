package com.boilerplate.reactivekafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ReactiveKafkaConsumer {

    @KafkaListener(topics = "reactive-topic", groupId = "group-id")
    public void listen(String message) {
        System.out.println("Received Message: " + message);
    }
}