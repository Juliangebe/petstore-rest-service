package io.swagger.petstore.store;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.swagger.petstore.user.UserDeleteRequests;
import io.swagger.petstore.user.UserGetRequests;
import io.swagger.petstore.user.UserPutRequests;
import io.swagger.petstore.utils.JsonMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.*;

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

    @BeforeEach
    public void createData() {
        StorePostRequests.placePetOrder(placeOrderBody);
    }

    @Test
    @DisplayName("E2E TEST : Should list,place order,delete and verify the store data")
    public void e2eStoreTest() {
        getInventoryByStatus();
        createPetOrder();
        deletePetOrderById();
    }


    @Test
    @DisplayName("Should list the inventory by status successfully")
    public void getInventoryByStatus() {
        StoreGetRequests.inventoriesByStatus().then().statusCode(200).log().all();
    }

    @Test
    @DisplayName("Should create a Pet order successfully")
    public void createPetOrder() {
        StorePostRequests.placePetOrder(placeOrderBody);
        Response response = StoreGetRequests.inventoriesByStatus().then().extract().response();
        Assertions.assertNotEquals(placeOrderModel.getString("status"), response.jsonPath().getString("status"));

    }

    @Test
    @DisplayName("Should delete a Pet order by id successfully")
    public void deletePetOrderById() {
        StoreGetRequests.findOrderById(placeOrderModel.getInt("id")).then().statusCode(200).log().all();
        StoreDeleteRequests.orderById(placeOrderModel.getInt("id"));
    }


}
