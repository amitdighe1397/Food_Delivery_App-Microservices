package com.example.User_Service.controller;

import com.example.User_Service.payloads.AddressRequest;
import com.example.User_Service.payloads.UserRequest;
import com.example.User_Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
    @RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create a new user
    @PostMapping
    public ResponseEntity<UserRequest> createUser(@RequestBody UserRequest userRequest) {
        return new ResponseEntity<UserRequest>(userService.createUser(userRequest), HttpStatus.CREATED);
    }

    // Get user details
    @GetMapping("/{userid}")
    public ResponseEntity<UserRequest> getUserById(@PathVariable Long userid) {
        return new ResponseEntity<UserRequest>(userService.getUserById(userid), HttpStatus.OK);
    }

    // Add delivery address
    @PostMapping("/{userid}")
    public ResponseEntity<AddressRequest> addAddress(@PathVariable Long userid, @RequestBody AddressRequest addressRequest) {
        return new ResponseEntity<AddressRequest>(userService.addAddress(userid, addressRequest), HttpStatus.CREATED);
    }

    @GetMapping("address/{userId}")
    public ResponseEntity<List<AddressRequest>> getUserAddresses(@PathVariable Long userId) {
        return new ResponseEntity<List<AddressRequest>>(userService.getUserAddresses(userId), HttpStatus.OK);
    }
}

