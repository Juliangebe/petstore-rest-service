package io.swagger.petstore.store;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.swagger.petstore.utils.JsonMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
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
    @DisplayName("Should list,place order,delete and verify the store data")
    public void e2eStoreTest() {

        int initialValue =
                StoreGetRequests.inventoriesByStatus().then().statusCode(200).log().all()
                        .extract().response().jsonPath().getInt(placeOrderModel.getString("status"));


        StorePostRequests.placePetOrder(placeOrderBody);

        int finalValue =
                StoreGetRequests.inventoriesByStatus().then().statusCode(200).log().all()
                        .extract().jsonPath().getInt(placeOrderModel.getString("status"));


        Assertions.assertNotEquals(initialValue, finalValue);

        StoreDeleteRequests.orderById(placeOrderModel.getInt("id"));

        Response response = StoreGetRequests.inventoriesByStatus().then()
                .statusCode(200).log().all().extract().response();

        Assertions.assertEquals(response.jsonPath().getInt(placeOrderModel.getString("status")), initialValue);


    }


}
