package io.swagger.petstore.pet;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class DeleteRequests {
    public DeleteRequests() {
    }

    public static void byId(int id) {

        given()
                .contentType(ContentType.JSON)
                .pathParam("petId", id)
                .delete("/pet/{petId}");
    }
}
