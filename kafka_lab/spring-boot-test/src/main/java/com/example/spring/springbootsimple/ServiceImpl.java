package com.example.spring.springbootsimple;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceImpl{
    private final KafkaTemplate<Long, String> kafkaTemplate;

    @Autowired
    public ServiceImpl(KafkaTemplate<Long, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    //отправка сообщения на сервер
    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    public void produce() {
        String message = "App Info:  " + java.time.LocalDateTime.now().toString();
        System.out.println("App sending: " + message);
        kafkaTemplate.send("server.info", message);
    }

}
