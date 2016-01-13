
# Async task with spring-boot

Controller that returns immediately and a task runs in a different thread asynchronously.

This example contains 3 different scenarios:

## Future - Async API

Sample using spring @Async to execute a task/service that returns a Future (the caller invokes a method that runs asynchronously)

## Callable - Consumed Async

Calling a sync method in a different thread (making the caller async)

## DeferredResult/CompletableFuture - Consumed Async

Calling a sync method with CompletableFuture (making the caller async)