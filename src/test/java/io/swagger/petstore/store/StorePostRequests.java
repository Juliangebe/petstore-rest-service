package io.swagger.petstore.store;

import io.restassured.http.ContentType;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class StorePostRequests {

    public StorePostRequests() {
    }


    public static void placePetOrder(String body) {

        given()
                .contentType(ContentType.JSON)
                .body(body)
                .post("/store/order");

    }

}
