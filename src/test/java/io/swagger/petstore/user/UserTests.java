package io.swagger.petstore.user;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.swagger.petstore.models.UserModel;
import io.swagger.petstore.utils.JsonMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class UserTests {

    static UserModel userModel;

    @BeforeAll
    public static void setUp() throws IOException {
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "/api/v3";
        String placeOrderBody = JsonMapper.jsonToString("src/test/resources/jsonfiles/user/createSingleUserBody.json");
        userModel = (UserModel) JsonMapper.jsonStringToModel(placeOrderBody, UserModel.class);
    }

    @Test
    public void e2eUserTest() {




        UserGetRequests.userLogin("automation", "test").then().statusCode(200).log().all();
        UserDeleteRequests.byUsername("automation");
        UserGetRequests.getByUsername("automation").then().statusCode(404).log().all();


    }
}
