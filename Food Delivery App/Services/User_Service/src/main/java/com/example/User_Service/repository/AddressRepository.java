package com.example.User_Service.repository;

import com.example.User_Service.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface AddressRepository extends MongoRepository<Address, Long> {

    // Find all addresses for a specific user
    List<Address> findByUserId(Long userId);
}
