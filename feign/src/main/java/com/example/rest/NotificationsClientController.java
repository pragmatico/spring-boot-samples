package com.example.rest;


import com.example.services.NotificationsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller that defines /publish http endpoint. When invoking this endpoint, a notification is
 * post to http://localhost:8080/notifications using the Feign client
 *
 * @author jmbataller
 */
@RestController
public class NotificationsClientController {

    private static final Logger LOGGER = LogManager.getLogger(NotificationsClientController.class);

    @Autowired
    private NotificationsService notificationsService;

    @RequestMapping("/publish")
    public void sendNotification() {
        notificationsService.sendNotification("test", "test data!!!");
    }

}
