package com.example.services;

import java.util.concurrent.Future;

public interface TaskService {

    Future<Void> process(String data) throws InterruptedException;
}
