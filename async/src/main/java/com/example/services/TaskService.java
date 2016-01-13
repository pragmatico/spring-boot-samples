package com.example.services;

import java.util.concurrent.Future;

public interface TaskService {

    Future<Void> processAsync(String data);

    String processSync(String data);
}
