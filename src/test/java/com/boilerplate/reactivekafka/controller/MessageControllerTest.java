package com.boilerplate.reactivekafka.controller;

import com.boilerplate.reactivekafka.service.ReactiveKafkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import static org.mockito.BDDMockito.given;

@WebFluxTest(MessageController.class)
public class MessageControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private ReactiveKafkaProducer producer;

    @Test
    public void testSendMessage() {
        String message = "Hello, Kafka!";
        given(producer.sendMessage("reactive-topic", message)).willReturn(Mono.empty());

        webTestClient.post().uri("/send?message=" + message)
                .exchange()
                .expectStatus().isOk();
    }
}
