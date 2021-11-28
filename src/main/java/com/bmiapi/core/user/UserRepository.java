package com.bmiapi.core.user;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    UUID save(User user);

    Optional<User> findById(UUID uuid);

    List<User> findAll();

}
