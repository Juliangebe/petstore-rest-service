# Petstore Api testing

## Overview
This Java project uses the Rest assured library to test Restful Web services, a project in charge of carrying out a test suite on the local Swagger Petstore server.

## Required software.
* Java JDK 17+.
* Maven installed and in your classpath.
* Setup Swagger Petsore in the local environment as explained in [Readme](https://github.com/swagger-api/swagger-petstore).
* Before executing any tests, run the Swagger Petstore locally,that's why the BaseUrl is `http://localhost:8080`.

## How to execute the tests


### To run (with Maven)
To run all the tests,run this task:

```
mvn suite 
```
This will run all the tests with the `@Test` annotation and generates an `.html` report on  the generated source `target/site/surefire-report.html`.

### Running manually the test suites

The test suites can be run directly by your IDE or by command line.
If you run `mvn test` all the tests will execute because it's the regular Maven lifecycle to run all the tests.

To run different E2E suites based on the groups defined for each test you must inform the property `-Dtest` and the test names.
The example below shows how to run the test for each pipeline stage:

| pipeline stage     | command                          |
|--------------------|----------------------------------|
| Pet check tests    | `mvn test  -Dtest=PetTests`      |
| Store tests        | `mvn test  -Dtest=StoreTests`    |
| User tests         | `mvn test  -Dtest=UserTests`     |


You also can execute each test class on  `src\test\java` and execute all of them individually or as Suite.

# NOTE
### When the report is generated, live and detailed documentation on the test cases is generated, such as its name, its unique record, input data, expected result, status. Since this is the idea of a test automation that helps to test a test suite quickly helping continuous deliveries, saving time and money.
## List of test cases proposed for automation.
Test created for each functionality necessary to perform an e2e flow.

## Pet:
* Update pet :  expected to update pet information.
* Add pet : expected to add a pet.
* List pet by status,tag and id : expected to list pets by param.
* Delete pet by id : expected to delete pet information.
* E2E Test : modifies and verifies the creation, update, deletion and listing of the data used in the functionality,which modifies and verifies the creation, update, deletion and listing of the data used in the functionality, making use of all the components and exchanging information between tests.

## Store:
* Create order : expected to add an order.
* List store inventory by status and id : expected to list store inventory by param.
* Delete order by id : expected to delete order information.
* E2E Test : modifies and verifies the creation, update, deletion and listing of the data used in the functionality,which modifies and verifies the creation, update, deletion and listing of the data used in the functionality, making use of all the components and exchanging information between tests.

## Pet:
* Log in user: expected to log in successfully.
* Log out user: expected to log out successfully.
* Update user :  expected to update user information.
* Create user : expected to add a user.
* List user by username : expected to list user information.
* Delete user by id : expected to delete user information.
* E2E Test : modifies and verifies the creation, update, deletion and listing of the data used in the functionality,which modifies and verifies the creation, update, deletion and listing of the data used in the functionality, making use of all the components and exchanging information between tests.

# Explanation of the provided solution
Encapsulated methods were created with the current functionalities of the application, to be able to be called in one or several tests that need it and thus help with reusability and help make the code more extensible.
The basic functionalities that are necessary for the system to work as a whole and carry out complete test scenarios were tested separately.
Test scenarios help us identify what specific functionality the test suite may have failed.

# Explain your approach and why you chose the particular tech stack.
The Java programming language allows you to create scalable systems and, together with Rest Assured, allows you to create automation frameworks that, with a good level of abstraction, allow the code to be reusable, maintainable, and extensible.
The methods were created to be used generically in different tests.
Libraries such as Jackson were added and utilities for handling Json and created data models.
Junit is used as a tool to run the tests and maven's surefire plugin for general documentation.

### All these tools together with good development practices help us create scalable, maintainable and extensible systems, some factors such as design patterns, libraries, validations, abstraction level, are things that can be discussed with the work team or adapted according to the needs of the client or the business rules, everything proposed in this development is based on good practices and knowledge that can be adapted to the requirements.







