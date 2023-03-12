package io.swagger.petstore.pet;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class PetPutRequests {

    public PetPutRequests() {
    }

    public static void updatePet(String body) {

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .put("/pet")
                .then().statusCode(200)
                .log().ifError();


    }
}
