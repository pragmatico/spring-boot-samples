### Sample testing spring-boot metrics

Setup of spring-boot metrics and Dropwizard metrics extension sending metrics to StatsD

This sample sends the following metrics to statsD:

- Counter for number for number of requests send to each REST endpoint
- Timer for each REST operation
- Sample of timing a task using lambdas
- Sample of creating a service component to increment counters of metrics

