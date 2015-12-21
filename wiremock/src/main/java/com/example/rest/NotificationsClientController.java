package com.example.rest;


import com.example.services.NotificationsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller with different http endpoints that invoke the notifications service layer which contains a feign client
 * and a hystrix command circuit breaker
 *
 * @author jmbataller
 */
@RestController
public class NotificationsClientController {

    private static final Logger LOGGER = LogManager.getLogger(NotificationsClientController.class);

    @Autowired
    private NotificationsService notificationsService;

    @RequestMapping("/async-publish")
    public void asyncSendNotification() {
        notificationsService.sendNotification("test", "test data!!!");
    }

}
