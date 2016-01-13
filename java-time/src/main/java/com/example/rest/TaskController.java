package com.example.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jmbataller
 */
@RestController
public class TaskController {

    @RequestMapping("/process")
    public String process() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        long elapsedTime = System.currentTimeMillis() - startTime;
        return "elapsedTime = " + elapsedTime;
    }
}
