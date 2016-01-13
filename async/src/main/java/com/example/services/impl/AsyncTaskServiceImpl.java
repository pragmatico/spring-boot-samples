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
    public Future<Void> process(String data) throws InterruptedException {
        Thread.sleep(5000L);
        LOGGER.info("processing done!!!");
        return new AsyncResult<Void>(null);
    }
}
