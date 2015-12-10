package com.example.domain;

import lombok.Data;

@Data
public class User {

    private String username;
    private String password;
    private String email;

    public static User newInstance() {
        return new User();
    }
}
