package com.example.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author jmbataller
 */
@RestController
@RequestMapping("/notifications")
public class NotificationsController {

    private static final Logger LOGGER = LogManager.getLogger(NotificationsController.class);

    @RequestMapping(value = "/{type}", method = RequestMethod.POST, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String processNotification(@RequestBody String payload,
                                    @PathVariable(value = "type") String type) {
        throw new UnsupportedOperationException();
        //LOGGER.info(type + " notification received. Content: " + payload);
        //return "received!!!";
    }
}
