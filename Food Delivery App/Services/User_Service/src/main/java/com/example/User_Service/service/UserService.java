package com.example.User_Service.service;

import com.example.User_Service.payloads.AddressRequest;
import com.example.User_Service.payloads.UserRequest;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserRequest createUser(UserRequest userRequest);

    UserRequest getUserById(Long userId);

    AddressRequest addAddress(Long userId, AddressRequest address);

    List<AddressRequest> getUserAddresses(Long userId);
}

