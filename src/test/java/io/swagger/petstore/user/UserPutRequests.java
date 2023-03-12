package io.swagger.petstore.user;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class UserPutRequests {

    public UserPutRequests() {
    }

    public static void updateUserByName(String username) {

        given()
                .contentType(ContentType.JSON)
                .pathParam("username", username)
                .post("/user/{username}")
                .then().log().ifError();

    }
}
