package com.example.services.impl;

import com.example.clients.NotificationsClient;
import com.example.services.NotificationsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jmbataller
 */
@Service
public class NotificationsServiceImpl implements NotificationsService {

    private static final Logger LOGGER = LogManager.getLogger(NotificationsServiceImpl.class);

    @Autowired
    private NotificationsClient notificationsClient;

    @HystrixCommand(fallbackMethod = "handleError")
    public void sendNotification(String type, String content) {
        notificationsClient.publish("test", "test data!!!");
    }

    private void handleError(String type, String content) {
        LOGGER.error("Failed sending notification: " + type + " with content: " + content);
    }
}
