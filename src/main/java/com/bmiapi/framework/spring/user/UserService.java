package com.bmiapi.framework.spring.user;

import com.bmiapi.core.user.User;
import com.bmiapi.core.user.usecase.CreateUserUseCase;
import com.bmiapi.core.user.usecase.FindUserUseCase;
import com.bmiapi.framework.spring.user.web.CreateUserWebOutput;
import com.bmiapi.framework.spring.user.web.UserWebInput;
import com.bmiapi.framework.spring.user.web.UserWebOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private CreateUserUseCase createUserUseCase;

    private FindUserUseCase findUserUseCase;

    private UserConverter userConverter;

    @Autowired
    public UserService(CreateUserUseCase createUseCase,
                       FindUserUseCase findUseCase,
                       UserConverter converter) {

        this.createUserUseCase = createUseCase;
        this.findUserUseCase = findUseCase;
        this.userConverter = converter;
    }

    public CreateUserWebOutput createUser(UserWebInput inputPayload) {

        UUID uuid = createUserUseCase.create(userConverter.toUser(inputPayload));

        return new CreateUserWebOutput(uuid);
    }

    public List<UserWebOutput> findAll() {

        List<User> users = findUserUseCase.findAll();

        List<UserWebOutput> outUsers = users
                .stream()
                .map(u->userConverter.toUserOutput(u))
                .collect(Collectors.toList());

        return outUsers;
    }

    public UserWebOutput findById(UUID userId) {

        User user = findUserUseCase.findById(userId);

        return userConverter.toUserOutput(user);
    }
}
