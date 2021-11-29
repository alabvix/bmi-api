package com.bmiapi.core.user;

import com.bmiapi.core.user.exception.InvalidUserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

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
        InvalidUserException ex =
                Assertions.assertThrows(InvalidUserException.class, () -> {
            userValidator.validate(user);
        });

        // Then
        assertEquals("Email cannot be empty,Email cannot be null", ex.getMessage());

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
        InvalidUserException ex =
                Assertions.assertThrows(InvalidUserException.class, () -> {
                    userValidator.validate(user);
                });

        // Then
        assertEquals("Email cannot be empty", ex.getMessage());

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
        InvalidUserException ex =
                Assertions.assertThrows(InvalidUserException.class, () -> {
                    userValidator.validate(user);
                });
        // Then
        assertEquals("Email must be valid", ex.getMessage());

    }

    public void validate_valid_email_should_not_throw_validation_exception() {

        // Given
        User user = new User(
                null,
                "USER1",
                "teste@teste.com",
                new BigDecimal(1.70),
                new BigDecimal(60.0),
                20);

        // When, then
        assertDoesNotThrow(() -> userValidator.validate(user));

    }
}
