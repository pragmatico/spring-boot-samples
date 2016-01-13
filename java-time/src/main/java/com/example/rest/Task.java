package com.example.rest;

import java.time.LocalDateTime;

public class Task {

    LocalDateTime created;

    public Task() {
        created = LocalDateTime.now();
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
}
