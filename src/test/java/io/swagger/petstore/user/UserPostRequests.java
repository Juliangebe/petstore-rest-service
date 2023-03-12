package io.swagger.petstore.user;

import io.restassured.http.ContentType;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserPostRequests {

    public UserPostRequests() {
    }


    public static void createUser(String body) {

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .post("/user")
                .then().log().ifError();

    }


    public static void createUsersList(String body) {


        given()
                .contentType(ContentType.JSON)
                .body(body)
                .post("/user/createWithList")
                .then().log().ifError();


    }


}
