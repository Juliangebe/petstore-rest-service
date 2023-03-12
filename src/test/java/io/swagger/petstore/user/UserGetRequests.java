package io.swagger.petstore.user;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;


public class UserGetRequests {

    public UserGetRequests() {
    }


    public static Response userLogin(String username, String password) {

        return given()
                .queryParam("username", username)
                .queryParam("password", password)
                .contentType(ContentType.JSON)
                .get("/user/login");

    }


    public static Response userLogout() {

        return
                given()
                        .contentType(ContentType.JSON)
                        .get("/user/logout");
    }


    public static Response getByUsername(String username) {

        return
                given()
                        .header("accept", "application/json")
                        .pathParam("username", username)
                        .contentType(ContentType.JSON)
                        .get("/user/{username}");


    }

}
