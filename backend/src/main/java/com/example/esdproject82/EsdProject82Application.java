package com.example.esdproject82;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class EsdProject82Application {
    public static void main(String[] args) {
        SpringApplication.run(EsdProject82Application.class, args);
    }

}
