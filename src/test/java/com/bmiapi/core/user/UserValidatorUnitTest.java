package com.bmiapi.core.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserValidatorUnitTest {

    UserValidator userValidator;

    @BeforeEach
    public void beforeEach() {
        userValidator = new UserValidator();
    }

    @Test
    public void validate_null_email_should_return_validation_message() {

        // Given
        User user = new User(null,
                "USER1",
                null,
                new BigDecimal(1.70),
                new BigDecimal(60.0),
                20);

        // When
        String msg = userValidator.validate(user);

        // Then
        assertEquals("Email cannot be empty,Email cannot be null", msg);

    }

    @Test
    public void validate_empty_email_should_return_validation_message() {

        // Given
        User user = new User(
                null,
                "USER1",
                "",
                new BigDecimal(1.70),
                new BigDecimal(60.0),
                20);

        // When
        String msg = userValidator.validate(user);

        // Then
        assertEquals("Email cannot be empty", msg);

    }

    @Test
    public void validate_invalid_email_should_return_validation_message() {

        // Given
        User user = new User(
                null,
                "USER1",
                "ddd-dsd33@",
                new BigDecimal(1.70),
                new BigDecimal(60.0),
                20);

        // When
        String msg = userValidator.validate(user);

        // Then
        assertEquals("Email must be valid", msg);

    }

    @Test
    public void validate_valid_email_should_not_return_validation_message() {

        // Given
        User user = new User(
                null,
                "USER1",
                "teste@teste.com",
                new BigDecimal(1.70),
                new BigDecimal(60.0),
                20);

        // When
        String msg = userValidator.validate(user);

        // Then
        assertEquals("", msg);

    }
}
