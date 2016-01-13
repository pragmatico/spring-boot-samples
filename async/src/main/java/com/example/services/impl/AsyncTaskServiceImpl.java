package com.example.services.impl;

import com.example.services.TaskService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
public class AsyncTaskServiceImpl implements TaskService {

    private static final Logger LOGGER = LogManager.getLogger(AsyncTaskServiceImpl.class);

    @Async
    @Override
    public Future<Void> processAsync(String data) {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        LOGGER.info("processing done!!!");
        return new AsyncResult<Void>(null);
    }

    @Override
    public String processSync(String data) {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        LOGGER.info("processing done!!!");
        return "data_processed";
    }
}
