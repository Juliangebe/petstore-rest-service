package io.swagger.petstore.user;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class UserPutRequests {

    public UserPutRequests() {
    }

    public static void updateUserByName(String body, String username) {

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .pathParam("username", username)
                .put("/user/{username}")
                .then().log().ifError();

    }
}
