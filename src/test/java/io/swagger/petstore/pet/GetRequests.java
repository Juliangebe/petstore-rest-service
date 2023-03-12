package io.swagger.petstore.pet;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;


public class GetRequests {

    public GetRequests() {
    }


    public static Response byId(int id) {

        return given()
                .pathParam("petId", id)
                .contentType(ContentType.JSON)
                .when()
                .get("/pet/{petId}");

    }


    public static Response byStatus(String status) {

        return
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .queryParam("status", status)
                        .get("/pet/findByStatus");
    }


    public static Response byTags(Map<String, String> queryParams) {

        return
                given()
                        .header("accept", "application/json")
                        .contentType(ContentType.JSON)
                        .queryParams(queryParams)
                        .get("/pet/findByTags");


    }

}
