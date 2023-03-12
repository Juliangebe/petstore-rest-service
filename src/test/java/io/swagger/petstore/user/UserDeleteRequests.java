package io.swagger.petstore.user;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class UserDeleteRequests {
    public UserDeleteRequests() {
    }

    public static void byUsername(String username) {

        given()
                .contentType(ContentType.JSON)
                .pathParam("username", username)
                .delete("/user/{username}")
                .then().log().ifError();
    }
}
