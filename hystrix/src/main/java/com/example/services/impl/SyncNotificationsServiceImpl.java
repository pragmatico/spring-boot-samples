package com.example.services.impl;

import com.example.clients.NotificationsClient;
import com.example.services.SyncNotificationsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jmbataller
 */
@Service
public class SyncNotificationsServiceImpl implements SyncNotificationsService {

    private static final Logger LOGGER = LogManager.getLogger(SyncNotificationsServiceImpl.class);

    @Autowired
    private NotificationsClient notificationsClient;

    @HystrixCommand(fallbackMethod = "handleError")
    public void sendNotification(String type, String content) {
        LOGGER.info("Sending notifications: " + type + " with content:" + content);
        notificationsClient.publish("test", "test data!!!");
    }

    private void handleError(String type, String content) {
        LOGGER.error("Failed sending notification: " + type + " with content: " + content);
    }
}
