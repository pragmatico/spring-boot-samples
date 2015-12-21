package com.example.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author jmbataller
 */
@FeignClient(name = "notifications")
public interface NotificationsClient {

    @RequestMapping(value = "/notifications/{type}", method = RequestMethod.POST)
    Void publish(@PathVariable("type") String type, String content);

}