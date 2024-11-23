package com.example.User_Service.serviceImpl;

import com.example.User_Service.exception.UserNotFoundException;
import com.example.User_Service.model.Address;
import com.example.User_Service.model.User;
import com.example.User_Service.payloads.AddressRequest;
import com.example.User_Service.payloads.UserRequest;
import com.example.User_Service.repository.AddressRepository;
import com.example.User_Service.repository.UserRepository;
import com.example.User_Service.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserRequest createUser(UserRequest userRequest) {
        Long userId = UUID.randomUUID().getLeastSignificantBits();
        userRequest.setId(userId);
        User user = modelMapper.map(userRequest, User.class);
        return modelMapper.map(userRepository.save(user), UserRequest.class);
    }

    @Override
    public UserRequest getUserById(Long userId) {
        return modelMapper.map(userRepository.findById(userId), UserRequest.class);
    }

    @Override
    public AddressRequest addAddress(Long userId, AddressRequest addressRequest) {
        Long ID = UUID.randomUUID().getLeastSignificantBits();
        addressRequest.setId(ID);
        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        Address address = modelMapper.map(addressRequest, Address.class);
        address.setUser(user);
        return modelMapper.map(addressRepository.save(address), AddressRequest.class);
    }

    @Override
    public List<AddressRequest> getUserAddresses(Long userId) {
        List<Address> list = addressRepository.findByUserId(userId);
        return list.stream()
                .map(address -> modelMapper.map(address, AddressRequest.class))
                .collect(Collectors.toList());
    }
}

