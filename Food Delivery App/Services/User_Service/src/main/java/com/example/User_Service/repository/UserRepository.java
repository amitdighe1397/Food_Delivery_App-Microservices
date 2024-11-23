package com.example.User_Service.repository;

import com.example.User_Service.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends MongoRepository<User, Long> {

    // Find a user by email (if needed)
    Optional<User> findByEmail(String email);
}
