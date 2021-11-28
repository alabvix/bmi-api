package com.bmiapi.core.user.usecase;

import com.bmiapi.core.user.exception.InvalidUserException;
import com.bmiapi.core.user.User;
import com.bmiapi.core.user.UserRepository;
import com.bmiapi.core.user.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateUserUseCase {

    final Logger logger = LoggerFactory.getLogger(CreateUserUseCase.class);

    private UserRepository userRepository;

    private UserValidator userValidator;

    public CreateUserUseCase(UserRepository repository, UserValidator validator) {
        this.userRepository = repository;
        this.userValidator = validator;
    }

    public void create(User user) {

        String violationMessages = userValidator.validate(user);
        if (!violationMessages.isEmpty()) {
            logger.error(violationMessages);
            throw new InvalidUserException(violationMessages);
        }

        userRepository.save(user);

    }

}
