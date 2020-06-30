package com.jinjie.sun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SunApplication {

    public static void main(String[] args) {
        SpringApplication.run(SunApplication.class, args);
    }

    @RequestMapping(value = "/hello")
    String index() {
        return "Hello Spring Boot!";
    }
}
