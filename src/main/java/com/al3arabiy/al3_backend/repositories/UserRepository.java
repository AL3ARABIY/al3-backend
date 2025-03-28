package com.al3arabiy.al3_backend.repositories;

import com.al3arabiy.al3_backend.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String username);
}
