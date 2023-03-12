package io.swagger.petstore.pet;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class PetDeleteRequests {
    public PetDeleteRequests() {
    }

    public static void byId(int id) {

        given()
                .contentType(ContentType.JSON)
                .pathParam("petId", id)
                .delete("/pet/{petId}")
                .then().log().ifError();
    }
}
