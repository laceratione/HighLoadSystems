package com.example.spring.springbootsimple;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @GetMapping("/")
    public ResponseEntity<String> getCount() {
        Counter.inc();
        return ResponseEntity.ok("{\"counter\":\"" + Counter.count + "\"}");
    }

}