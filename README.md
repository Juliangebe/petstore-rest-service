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
mvn clean test surefire-report:report 
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
### When the report is generated, live and detailed documentation on the test cases is generated, such as its name, its unique record, input data, expected result,time execution, status. Since this is the idea of a test automation that helps to test a test suite quickly helping continuous deliveries, saving time and money.

![image](https://user-images.githubusercontent.com/32660114/224604421-e721af6b-f16e-4ed7-bb76-514085a385b1.png)







