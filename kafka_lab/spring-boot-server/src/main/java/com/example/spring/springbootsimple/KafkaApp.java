package com.example.spring.springbootsimple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//сервер, принимающий и отправляющий сообщения
@SpringBootApplication
public class KafkaApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(KafkaApp.class, args);
    }

}