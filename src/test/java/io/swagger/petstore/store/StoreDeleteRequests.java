package io.swagger.petstore.store;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class StoreDeleteRequests {
    public StoreDeleteRequests() {
    }

    public static void orderById(int orderId) {

        given()
                .contentType(ContentType.JSON)
                .pathParam("orderId", orderId)
                .delete("/store/order/{orderId}");
    }
}
