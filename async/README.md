
# Async task with spring-boot

Controller that returns immediately and a task runs in a different thread asynchronously.

This example contains 3 different scenarios:

## Future - Async API

Sample using spring @Async to execute a task/service that returns a Future (the caller invokes a method that runs asynchronously)

## Callable - Consumed Async

Calling a sync method in a different thread (making the caller async)

## DeferredResult/CompletableFuture - Consumed Async

Calling a sync method with CompletableFuture (making the caller async)




---------
References:

- http://callistaenterprise.se/blogg/teknik/2014/04/22/c10k-developing-non-blocking-rest-services-with-spring-mvc/
- http://xpadro.blogspot.co.uk/2015/07/understanding-callable-and-spring.html