package io.swagger.petstore.store;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;


public class StoreGetRequests {

    public StoreGetRequests() {
    }


    public static Response inventoriesByStatus() {

        return given()
                .contentType(ContentType.JSON)
                .when()
                .get("/store/inventory");

    }


    public static Response findOrderById(int orderId) {

        return given()
                .pathParam("orderId", orderId)
                .contentType(ContentType.JSON)
                .when()
                .get("/store/order/{orderId}");

    }


}
