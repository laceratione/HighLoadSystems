package com.example.spring.springbootsimple;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/")
    public ResponseEntity<String> getCount() {
        Counter redisCounter = new Counter();
        int count = redisCounter.getCount();
        return ResponseEntity.ok("{\"counter\":\"" + count + "\"}");
    }

}