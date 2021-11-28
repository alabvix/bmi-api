package com.bmiapi.framework.spring.user.repository;

import com.bmiapi.core.user.User;
import com.bmiapi.core.user.UserRepository;
import com.bmiapi.framework.spring.user.UserConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private UserConverter userConverter;

    private UserJpaRepository userJpaRepository;

    @Autowired
    public UserRepositoryImpl(UserConverter converter, UserJpaRepository repository) {
        this.userConverter = converter;
        this.userJpaRepository = repository;
    }

    @Override
    public UUID save(User user) {
        UserEntity entity = userConverter.toUserEntity(user);
        entity = userJpaRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Optional<User> findById(UUID uuid) {

        Optional<User> opUser = Optional.empty();
        Optional<UserEntity> opUserEntity = userJpaRepository.findById(uuid);

        if (opUserEntity.isEmpty()) {
            return opUser;
        }

        User user = userConverter.toUser(opUserEntity.get());
        opUser = Optional.of(user);

        return opUser;
    }

    @Override
    public List<User> findAll() {

        List<UserEntity> users = userJpaRepository.findAll();

        return users.stream()
                .map(u->userConverter.toUser(u))
                .collect(Collectors.toList());
    }
}
