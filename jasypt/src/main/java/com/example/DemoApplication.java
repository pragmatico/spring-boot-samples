package com.example;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class DemoApplication {

    @Value("test.password")
    private String password;

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);

    }
}
