package com.bmiapi.framework.spring.user;

import com.bmiapi.core.user.User;
import com.bmiapi.framework.spring.user.repository.UserEntity;
import com.bmiapi.framework.spring.user.web.UserWebInput;
import com.bmiapi.framework.spring.user.web.UserWebOutput;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public User toUser(UserWebInput payload) {
        return new User(null,
                payload.name(),
                payload.email(),
                payload.height(),
                payload.weight(),
                payload.age());
    }

    public UserEntity toUserEntity(User user) {
        UserEntity userEntity = new UserEntity();

        userEntity.setId(user.uuid());

        userEntity.setEmail(user.email());

        userEntity.setName(user.name());

        userEntity.setHeight(user.height());

        userEntity.setWeight(user.weight());

        userEntity.setAge(user.age());

        return userEntity;
    }

    public UserWebOutput toUserOutput(User user) {

        return new UserWebOutput(user.uuid(),
                user.name(),
                user.email(),
                user.height(),
                user.weight(),
                user.age());
    }

    public User toUser(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getHeight(),
                entity.getWeight(),
                entity.getAge());
    }
}
