### Sample testing REST interfaces

Sample that validates the request of a REST operation using hibernate-validator in spring boot.

There are 2 samples
- one to validate a request which is a POJO
- another to validate a request which is a list of POJOs, @Valid doesn't work in paramenters
that are Iterable and the example is using a wrapper for the list

For more info about hibernate-validate, please refer to official documentation:

(Hibernate Validator)[http://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/]



