package com.example.services.impl;

import com.example.clients.NotificationsClient;
import com.example.services.AsyncNotificationsService;
import com.example.services.SyncNotificationsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author jmbataller
 */
@Service
public class AsyncNotificationsServiceImpl implements AsyncNotificationsService {

    private static final Logger LOGGER = LogManager.getLogger(AsyncNotificationsServiceImpl.class);

    @Autowired
    private NotificationsClient notificationsClient;

    @HystrixCommand(fallbackMethod = "handleError", commandKey = "notifications")
    public Future<Void> sendNotification(String type, String content) {
        return new AsyncResult<Void>() {
            @Override
            public Void invoke() {
                return notificationsClient.publish("test", "test data!!!");
            }
        };
    }

    private Void handleError(String type, String content) {
        LOGGER.error("Failed sending notification: " + type + " with content: " + content);
        return null;
    }
}
