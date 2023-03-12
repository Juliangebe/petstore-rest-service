package io.swagger.petstore.pet;

import io.restassured.http.ContentType;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostRequests {

    public PostRequests() {
    }


    public static void addPet(String body) {

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .post("/pet");

    }


    public static void updateFieldsById(int id, Map<String, String> queryParams) {


        given()
                .pathParam("petId", id)
                .queryParams(queryParams)
                .contentType(ContentType.JSON)
                .post("/pet/{petId}");


    }


}
