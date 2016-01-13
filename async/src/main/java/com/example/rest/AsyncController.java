package com.example.rest;

import com.example.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jmbataller
 */
@RestController
public class AsyncController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/process")
    public String process() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        taskService.process("test data...");
        long elapsedTime = System.currentTimeMillis() - startTime;
        return "elapsedTime = " + elapsedTime;
    }
}
