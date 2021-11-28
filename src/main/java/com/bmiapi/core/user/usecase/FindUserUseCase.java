package com.bmiapi.core.user.usecase;

import com.bmiapi.core.user.User;
import com.bmiapi.core.user.UserRepository;
import com.bmiapi.core.user.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FindUserUseCase {

    private UserRepository userRepository;

    public FindUserUseCase(UserRepository repository) {
        this.userRepository = repository;
    }

    public User findById(UUID id) {

        Optional<User> opUser = userRepository.findById(id);
        if (opUser.isEmpty()) {
            throw new UserNotFoundException("User not found for id: " + id);
        }

        return opUser.get();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
