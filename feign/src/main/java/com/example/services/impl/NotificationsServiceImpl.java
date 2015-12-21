package com.example.services.impl;

import com.example.clients.NotificationsClient;
import com.example.services.NotificationsService;
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

    public void sendNotification(String type, String content) {
        notificationsClient.publish("test", "test data!!!");
    }
}
