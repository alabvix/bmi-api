package com.bmiapi.framework.spring.integration.user;

import com.bmiapi.framework.spring.integration.helper.DbHelper;
import com.bmiapi.framework.spring.integration.helper.IntegrationTestHelper;
import com.bmiapi.framework.spring.user.repository.UserEntity;
import com.bmiapi.framework.spring.user.web.UserWebOutput;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import java.math.BigDecimal;
import java.util.UUID;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FindUserIntegrationTest {

    @LocalServerPort
    private int port;

    private UserEntity user;

    private IntegrationTestHelper integrationHelper = new IntegrationTestHelper();

    private UserIntegrationTestHelper userHelper = new UserIntegrationTestHelper();

    @BeforeEach
    public void setUp() throws Exception {
        RestAssured.port = port;

        user = new UserEntity();
        user.setId(UUID.randomUUID());
        user.setName("Test User 1");
        user.setEmail("testeUser@test.com");
        user.setAge(30);
        user.setHeight(new BigDecimal("1.70"));
        user.setWeight(new BigDecimal("80.00"));

        DbHelper.createUser(user);
    }

    @AfterEach
    public void tearDown() throws Exception {
        DbHelper.deleteUser(user.getId());
    }

    @Test
    public void findUser_validId_shouldReturnUser() throws JsonProcessingException {
        final String URL =  "/users/" + user.getId() + "/user";

        Response response = integrationHelper.makeGetRequest(URL);

        assertEquals(response.getStatusCode(), HttpStatus.OK.value());

        UserWebOutput userWebOutput = userHelper.getUserWebOutput(response.getBody().asString());

        assertEquals(userWebOutput.id(), user.getId());
        assertEquals(userWebOutput.name(), user.getName());
        assertEquals(userWebOutput.age(), user.getAge());
        assertEquals(userWebOutput.email(), user.getEmail());
        assertEquals(userWebOutput.height(), user.getHeight());
        assertEquals(userWebOutput.weight(), user.getWeight());

    }

    @Test
    public void findUser_invalidId_shouldBadRequest() throws JsonProcessingException {

        final String INVALID_ID_URL =  "/users/00000/user";

        Response response = integrationHelper.makeGetRequest(INVALID_ID_URL);

        assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatusCode());

    }

    @Test
    public void findUser_notFoundUser_shouldNotFound() throws JsonProcessingException {

        final String INVALID_ID_URL =  "/users/" + UUID.randomUUID() + "/user";

        Response response = integrationHelper.makeGetRequest(INVALID_ID_URL);

        assertEquals(HttpStatus.NOT_FOUND.value(), response.getStatusCode());

    }

    @Test
    public void findUser_shouldResponse_lessThan_500ml() {
        final String URL =  "/users/" + user.getId() + "/user";
        when().get(URL).then().time(lessThan(5000L));
    }

}

