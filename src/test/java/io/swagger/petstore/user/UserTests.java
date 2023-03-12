package io.swagger.petstore.user;

import io.restassured.RestAssured;
import io.swagger.petstore.models.UserModel;
import io.swagger.petstore.utils.JsonMapper;
import org.junit.jupiter.api.*;

import java.io.IOException;

public class UserTests {

    static UserModel userModel;
    static UserModel updateUserModel;
    static String createUserBody;
    static String updateUserBody;

    @BeforeAll
    public static void setUp() throws IOException {
        RestAssured.baseURI = "http://localhost:8080";
        RestAssured.basePath = "/api/v3";
        createUserBody = JsonMapper.jsonToString("src/test/resources/jsonfiles/user/createSingleUserBody.json");
        userModel = (UserModel) JsonMapper.jsonStringToModel(createUserBody, UserModel.class);
        updateUserBody = JsonMapper.jsonToString("src/test/resources/jsonfiles/user/updateSingleUserBody.json");
        updateUserModel = (UserModel) JsonMapper.jsonStringToModel(createUserBody, UserModel.class);
    }

    @BeforeEach
    @DisplayName("Should prepare the data for tests")
    public void createData() {
        UserPostRequests.createUser(createUserBody);
    }

    @Test
    @DisplayName("E2E TEST : should use all user functionalities successfully")
    public void e2eUserTest() {

        loginUserTest();
        logoutUserTest();
        updateEmailUserTest();
        deleteUserTest();

    }

    @Test
    @DisplayName("Should log in successfully")
    public void loginUserTest() {
        UserGetRequests.getByUsername(userModel.getUsername()).then().statusCode(200).log().all();
        UserGetRequests.userLogin(userModel.getUsername(), userModel.getPassword()).then().log().ifError();

    }

    @Test
    @DisplayName("Should logout successfully")
    public void logoutUserTest() {
        UserGetRequests.userLogout();
    }

    @Test
    @DisplayName("Should delete the logged in user successfully")
    public void deleteUserTest() {
        UserDeleteRequests.byUsername(userModel.getUsername());
        UserGetRequests.getByUsername(userModel.getUsername()).then().statusCode(404).log().all();

    }

    @Test
    @DisplayName("Should update the logged in user successfully")
    public void updateEmailUserTest() {
        String initialEmail = UserGetRequests.getByUsername(userModel.getUsername()).then().log().all().extract().jsonPath().getString("email");
        UserPutRequests.updateUserByName(updateUserBody, updateUserModel.getUsername());
        String finalEmail = UserGetRequests.getByUsername(userModel.getUsername()).then().log().all().extract().jsonPath().getString("email");
        Assertions.assertNotEquals(initialEmail, finalEmail);

    }


}
