package com.example.spring.springbootsimple;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ServiceImpl{
    private final KafkaTemplate<Long, String> kafkaTemplate;

    @Autowired
    public ServiceImpl(KafkaTemplate<Long, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    //отправка сообщения
    public void send(String message) {
        kafkaTemplate.send("server.info", message);
    }

    //обработка входящего сообщение
    @KafkaListener(id = "Info", topics = {"server.info"}, containerFactory = "singleFactory")
    public void consume(String message) {
        System.out.println("Server consumed: " + message);
    }

}
