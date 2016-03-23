package com.example.rest;


import com.example.common.ValidatableBeanList;
import com.example.domain.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class TaskController {

    private static final Logger LOGGER = LogManager.getLogger(TaskController.class);

    @ResponseStatus(OK)
    @RequestMapping(value = "/tasks", method = GET, produces = APPLICATION_JSON_VALUE)
    public Map<String, String> getTasks() {
        Map<String, String> tasks = new HashMap<>();

        tasks.put("task1", "Build project");
        tasks.put("task2", "Deploy app to environment");

        return tasks;
    }

    /**
     * Uses hibernate annotations to validate request
     * @param task
     * @throws InterruptedException
     */
    @ResponseStatus(CREATED)
    @RequestMapping(value = "/tasks", method = POST, consumes = APPLICATION_JSON_VALUE)
    public void createTask(@RequestBody @Valid Task task) throws InterruptedException {
        LOGGER.info("Creating task...");
        Thread.sleep(500);
    }

    /**
     * POJOs with hibernate annotations are not validated when they are in a List
     * This example is using a wrapper for the List<Task> to validate the elements
     * of the list
     *
     * @param tasks
     * @throws InterruptedException
     */
    @ResponseStatus(CREATED)
    @RequestMapping(value = "/upload", method = POST, consumes = APPLICATION_JSON_VALUE)
    public void createTask(@RequestBody @Valid ValidatableBeanList<Task> tasks) throws InterruptedException {
        LOGGER.info("Uploading tasks...");
        Thread.sleep(500);
    }
}
