package io.swagger.petstore.store;

import io.restassured.RestAssured;
import io.swagger.petstore.utils.JsonMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class StoreTests {

    static String placeOrderBody;
    static JSONObject placeOrderModel;


    @BeforeAll
    public static void setUp() throws IOException {
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "/api/v3";
        placeOrderBody = JsonMapper.jsonToString("src/test/resources/jsonfiles/store/placeOrderBody.json");
        placeOrderModel = new JSONObject(placeOrderBody);
    }


    @Test
    @DisplayName("Should test")
    public void addNewPet() {
        StoreGetRequests.inventoriesByStatus().then().statusCode(200).log().all();

        StorePostRequests.placePetOrder(placeOrderBody);

        StoreGetRequests.inventoriesByStatus().then().statusCode(200).log().all();

        StoreDeleteRequests.orderById(1);

        StoreGetRequests.inventoriesByStatus().then().statusCode(200).log().all();


    }

    @Test
    public void e2eTest() {


    }


}
