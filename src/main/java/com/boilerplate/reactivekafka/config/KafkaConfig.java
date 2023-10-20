package com.boilerplate.reactivekafka.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@EnableKafka
public class KafkaConfig {
    // Here you can configure Kafka-related beans if needed.
    // For simplicity, we'll rely on application.properties for configuration.
}
