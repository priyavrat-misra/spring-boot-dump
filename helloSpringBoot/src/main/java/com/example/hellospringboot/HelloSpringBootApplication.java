package com.example.hellospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class HelloSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloSpringBootApplication.class, args);
    }

}

@RestController
class HelloController {

    @RequestMapping("/")
    String hello() {
        return "<samp>Hello, Spring Boot!</samp>";
    }

    // http://localhost:8080/greet/q?={q}
    @RequestMapping("/name")
    String hello(@RequestParam String q) {
	return "<samp>Hello, " + q + "!</samp>";
    }

    // http://localhost:8080/name/{q}
    @RequestMapping("/name/{q}")
    String hi(@PathVariable String q) {
	return "<samp>Hello, " + q + "!</samp>";
    }

}

