package com.bmiapi.framework.spring.integration.user;

import com.bmiapi.framework.spring.integration.helper.DbHelper;
import com.bmiapi.framework.spring.integration.helper.IntegrationTestHelper;
import com.bmiapi.framework.spring.user.web.CreateUserWebOutput;
import com.bmiapi.framework.spring.user.web.UserWebInput;
import com.bmiapi.framework.spring.user.web.UserWebOutput;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreateUserIntegrationTest {

    @LocalServerPort
    private int port;

    private IntegrationTestHelper integrationHelper = new IntegrationTestHelper();

    private UserIntegrationTestHelper userHelper = new UserIntegrationTestHelper();

    private UserWebInput userWebInput;

    private UUID createdUUID;

    @BeforeEach
    public void setUp() throws Exception {
        RestAssured.port = port;

        userWebInput = new UserWebInput(
                "Test User 1",
                "user@test.com",
                new BigDecimal("1.70"),
                new BigDecimal("80.00"),
                30
        );
    }

    @Test
    public void createUserTest() throws Exception {

        final String URL =  "/users/";

        Response response = integrationHelper.makePostRequest(URL,
                userHelper.parseUserInput(userWebInput));

        assertEquals(response.getStatusCode(), HttpStatus.OK.value());

        CreateUserWebOutput output = userHelper.getCreateUserWebOutput(response.getBody().asString());

        assertNotNull(output.userId());

        createdUUID = output.userId();

    }

    @AfterEach
    public void tearDown() throws Exception {
        DbHelper.deleteUser(createdUUID);
    }
}
