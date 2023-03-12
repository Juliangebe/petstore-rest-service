package io.swagger.petstore.pet;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.swagger.petstore.utils.JsonMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.*;

public class PetTests {

    static String createPetBody;
    static String updatePetBody;
    static JSONObject updatePetModel;
    static JSONObject createPetModel;


    @BeforeAll
    public static void setUp() throws IOException {
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "/api/v3";
        createPetBody = JsonMapper.jsonToString("src/test/resources/jsonfiles/pet/petCreateBody.json");
        updatePetBody = JsonMapper.jsonToString("src/test/resources/jsonfiles/pet/petUpdateBody.json");
        createPetModel = new JSONObject(createPetBody);
        updatePetModel = new JSONObject(updatePetBody);
    }

    @BeforeEach
    public void createData() {
        PostRequests.addPet(createPetBody);
    }

    @Test
    @DisplayName("Should create and validate the new pet data")
    public void addNewPet() {

        Response response =
                GetRequests.byId(createPetModel.getInt("id"))
                        .then().statusCode(200)
                        .body("id", notNullValue())
                        .log().all()
                        .extract().response();

        Assertions.assertEquals(response.jsonPath().getInt("id"), createPetModel.getInt("id"));


    }

    @Test
    @DisplayName("Should update and validate the pet data")
    public void updatePet() {

        PutRequests.updatePet(updatePetBody);

        GetRequests.byId(createPetModel.getInt("id"))
                .then().statusCode(200)
                .assertThat()
                .body("category.name", equalTo(updatePetModel.getJSONObject("category").getString("name")))
                .log().all();


    }

    @Test
    @DisplayName("Should delete and verify the pet data")
    public void deletePet() {

        GetRequests.byId(createPetModel.getInt("id"))
                .then().statusCode(200)
                .body("id", notNullValue())
                .log().ifError();

        DeleteRequests.byId(createPetModel.getInt("id"));

        GetRequests.byId(createPetModel.getInt("id"))
                .then().statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .log().ifError();


    }

    @Test
    @DisplayName("E2E TEST : Should create,update,list and delete the pet data")
    public void e2eTest() {

        GetRequests.byId(createPetModel.getInt("id"))
                .then().statusCode(200)
                .body("id", notNullValue());

        PutRequests.updatePet(updatePetBody);

        GetRequests.byId(createPetModel.getInt("id"))
                .then().statusCode(200)
                .body("status", equalTo(updatePetModel.getString("status")));

        DeleteRequests.byId(createPetModel.getInt("id"));

        GetRequests.byId(createPetModel.getInt("id"))
                .then().statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .log().ifError();


    }

}
