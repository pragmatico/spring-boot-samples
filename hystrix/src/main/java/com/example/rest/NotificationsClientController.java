package com.example.rest;


import com.example.services.AsyncNotificationsService;
import com.example.services.SyncNotificationsService;
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
    private SyncNotificationsService notificationsService;

    @Autowired
    AsyncNotificationsService asyncNotificationsService;

    /**
     * Controller that defines /publish http endpoint. When invoking this endpoint, a notification is
     * post to http://localhost:8080/notifications using the Feign client
     */
    @RequestMapping("/publish")
    public void sendNotification() {
        notificationsService.sendNotification("test", "test data!!!");
    }

    /**
     * /async-publish uses the "notification" HystrixCommand and the timeout is set to 5 secs
     * and because the /notifications takes 6 secs, a timeout exception is thrown and handled by
     * Hystrix, no error is shown to the client
     */
    @RequestMapping("/async-publish")
    public void asyncSendNotification() {
        asyncNotificationsService.sendNotification("test", "test data!!!");
    }

}
