package com.example.rest;


import com.codahale.metrics.annotation.Timed;
import com.example.metrics.TimerMetricWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class TaskController {

    private static final Logger LOG = LogManager.getLogger(TaskController.class);

    @Autowired
    private TimerMetricWriter timerMetricWriter;

    @Timed(absolute = true, name = "tasks")
    @ResponseStatus(OK)
    @RequestMapping(value = "/tasks", method = GET, produces = APPLICATION_JSON_VALUE)
    public Map<String, String> getTasks() {
        Map<String, String> tasks = new HashMap<>();

        tasks.put("task1", "Build project");
        tasks.put("task2", "Deploy app to environment");


        timerMetricWriter.time("test.timer.create.hashmap", () -> new HashMap<>());

        return tasks;
    }
}
