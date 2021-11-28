package com.bmiapi.core.user.usecase;

import com.bmiapi.core.user.exception.InvalidUserException;
import com.bmiapi.core.user.User;
import com.bmiapi.core.user.UserRepository;
import com.bmiapi.core.user.UserValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

public class CreateUserUseCaseUnitTest {

    CreateUserUseCase createUserUseCase;

    @Mock
    UserRepository repository;

    @Mock
    UserValidator validator;

    @BeforeEach
    public void beforeAll() {
        MockitoAnnotations.openMocks(this);
        createUserUseCase = new CreateUserUseCase(repository, validator);
    }

    @DisplayName("Given a user with all valid fields should create a new user in database")
    @Test
    public void create_valid_user_should_create() {

        // given
        User user = new User(null,
                "User1",
                "user1@bmc.com",
                new BigDecimal(1.80),
                new BigDecimal(75.0),
                31);
        when(validator.validate(user)).thenReturn("");

        // when
        createUserUseCase.create(user);

        // then
        verify(repository, times(1)).save(user);

    }

    @DisplayName("Given an user with invalid email should throw Invalid User Exception")
    @Test
    public void create_invalid_email_should_throw_invalid_user_exception() {

        // given
        User user = new User(null,
                "USER1",
                null,
                new BigDecimal(0.0),
                new BigDecimal(0.0),
                0);
        when(validator.validate(user)).thenReturn("Invalid User");

        // when
        Assertions.assertThrows(InvalidUserException.class, () -> {
            createUserUseCase.create(user);
        });

        // then
        verify(repository, times(0)).save(user);

    }

}
