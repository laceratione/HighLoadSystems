package com.example.spring.springbootsimple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

//тестовое приложение для отправки сообщений на сервер
@SpringBootApplication
@EnableKafka
@EnableScheduling
public class KafkaApp {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApp.class, args);
    }

}