package com.bmiapi.core.user.usecase;

import com.bmiapi.core.user.User;
import com.bmiapi.core.user.UserRepository;
import com.bmiapi.core.user.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class CreateUserUseCase {

    final Logger logger = LoggerFactory.getLogger(CreateUserUseCase.class);

    private final UserRepository userRepository;

    private final UserValidator userValidator;

    public CreateUserUseCase(UserRepository repository, UserValidator validator) {
        this.userRepository = repository;
        this.userValidator = validator;
    }

    public UUID create(User user) {

        userValidator.validate(user);

        UUID id = userRepository.save(user);

        logger.info("User created with UUID {}", id);

        return id;

    }

}
