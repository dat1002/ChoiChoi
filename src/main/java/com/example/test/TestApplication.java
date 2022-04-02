package com.example.test;

import com.github.slugify.Slugify;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestApplication {
    @Bean
    public Slugify slugify() {
        return new Slugify();
    }
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}
