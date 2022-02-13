package com.bmiapi.framework.spring.integration.helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class IntegrationTestHelper {

    public Response makeGetRequest(String url) {
        RequestSpecification httpRequest = RestAssured.given();
        return httpRequest.get(url);
    }

    public Response makePostRequest(String url, String body) {
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.post(url);
        httpRequest.body(body);
        httpRequest.contentType("application/json");
        return httpRequest.post(url);
    }
}
