package com.example;

import com.example.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);

        User u = User.newInstance();
        u.setUsername("test");
        System.out.println("User=" + u.getUsername());
    }
}
