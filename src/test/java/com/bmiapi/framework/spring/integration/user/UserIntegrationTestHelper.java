package com.bmiapi.framework.spring.integration.user;

import com.bmiapi.framework.spring.user.web.CreateUserWebOutput;
import com.bmiapi.framework.spring.user.web.UserWebInput;
import com.bmiapi.framework.spring.user.web.UserWebOutput;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

public class UserIntegrationTestHelper {

    public static UserWebOutput getUserWebOutput(String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(body, UserWebOutput.class);
    }

    public static CreateUserWebOutput getCreateUserWebOutput(String body) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(body,  CreateUserWebOutput.class);
    }

    public String parseUserInput(UserWebInput userWebInput) throws JSONException {
        JSONObject jsonObj = new JSONObject()
                .put("age", userWebInput.age())
                .put("email", userWebInput.email())
                .put("height", userWebInput.height())
                .put("name", userWebInput.name())
                .put("weight", userWebInput.weight());

        return jsonObj.toString();
    }
}
