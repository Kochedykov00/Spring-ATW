package com.example.myfirstspringproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication

public class MyFirstSpringProjectApplication {

    @Bean
    public PasswordEncoder passwordEncoder () {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ExecutorService executorService() {
        return Executors.newCachedThreadPool();
    }

    @Bean
    public RestTemplate restTemplate() { return new RestTemplate(); }


    @Bean
    public HttpHeaders httpHeaders() { return new HttpHeaders(); }


    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }




    public static void main(String[] args) {
        SpringApplication.run(MyFirstSpringProjectApplication.class, args);
    }



}
