package com.example.hellospringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
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
    @GetMapping("/")
    String hello() {
        return "<samp>Hello, Spring Boot!</samp>";
    }

    // http://localhost:8080/name?q={q} - query parameter
    @GetMapping("/name")
    String hello(@RequestParam String q) {
        return "<samp>Hello, " + q + "!</samp>";
    }

    // http://localhost:8080/name/{q} - path parameter
    @GetMapping("/name/{q}")
    String hi(@PathVariable String q) {
	return "<samp>Hello, " + q + "!</samp>";
    }
}

