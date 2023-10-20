package com.boilerplate.reactivekafka.controller;

import com.boilerplate.reactivekafka.service.ReactiveKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class MessageController {

    private final ReactiveKafkaProducer producer;

    @Autowired
    public MessageController(ReactiveKafkaProducer producer) {
        this.producer = producer;
    }

    @PostMapping("/send")
    public Mono<Void> sendMessage(@RequestParam String message) {
        return producer.sendMessage("reactive-topic", message);
    }
}