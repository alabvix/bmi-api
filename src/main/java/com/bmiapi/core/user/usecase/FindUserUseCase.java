package com.bmiapi.core.user.usecase;

import com.bmiapi.core.user.User;
import com.bmiapi.core.user.UserRepository;
import com.bmiapi.core.user.exception.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FindUserUseCase {

    final Logger logger = LoggerFactory.getLogger(CreateUserUseCase.class);

    private final UserRepository userRepository;

    public FindUserUseCase(UserRepository repository) {
        this.userRepository = repository;
    }

    public User findById(UUID id) {

        Optional<User> opUser = userRepository.findById(id);
        if (opUser.isEmpty()) {
            logger.warn("User not found for id: {}", id);
            throw new UserNotFoundException("User not found for id: " + id);
        }

        return opUser.get();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
