package com.example.rest;

import com.example.services.TaskService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

/**
 * @author jmbataller
 */
@RestController
public class AsyncController {

    private static final Logger LOGGER = LogManager.getLogger(AsyncController.class);

    @Autowired
    private TaskService taskService;

    /**
     * Sample of a async task processed in a different thread
     * @return
     */
    @RequestMapping("/async-task")
    public String processAsyncTask() {

        long startTime = System.currentTimeMillis();
        taskService.processAsync("test data...");
        long elapsedTime = System.currentTimeMillis() - startTime;
        return "elapsedTime = " + elapsedTime;

    }

    /**
     * Sample of async request processing using Callable
     *
     * Invokes the task defined in Callable in a different thread and Spring manages this thread by using
     * a TaskExecutor.
     *
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/async-callable")
    public Callable<String> processAsyncCallable() {

        Callable<String> callable = () -> taskService.processSync("test data...");

        // Servlet thread released
        LOGGER.info("Servlet thread released!!!");

        return callable;
    }

    /**
     * Sample of async request processing using DeferredResult and CompletableFuture
     *
     * Creates a new asynchronous task with CompletableFuture, this will create a new thread
     * where our task will be executed and this thread will sed the result to DeferredResult
     *
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/async-deferred")
    public DeferredResult<String> processAsyncDeferred() {

        // Create the deferredResult and initiate a callback object, task, with it
        DeferredResult<String> deferredResult = new DeferredResult<>();

        CompletableFuture.supplyAsync(() -> taskService.processSync("test data..."))
                .whenCompleteAsync((result, throwable) -> deferredResult.setResult(result));

        // Servlet thread released
        LOGGER.info("Servlet thread released!!!");

        return deferredResult;
    }
}
