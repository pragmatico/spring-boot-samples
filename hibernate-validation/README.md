### Sample testing REST interfaces

Sample that validates the request of a REST operation using hibernate-validator in spring boot.

There are 2 samples
- one to validate a request which is a POJO
- another to validate a request which is a list of POJOs, @Valid doesn't work in paramenters
that are Iterable and the example is using a wrapper for the list

---

Run the project with

> mvn spring-boot:run

Send requests to both REST endpoints:

Task:

> curl -X POST -H "Content-Type:application/json" http://localhost:8080/upload -d "{ \"list\": [{ \"units\": \"1\" }]}"

List of tasks:

> curl -X POST -H "Content-Type:application/json" http://localhost:8080/upload -d "{ \"list\": [{ \"units\": \"-1\" }]}"


For more info about hibernate-validate, please refer to official documentation:

http://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/



