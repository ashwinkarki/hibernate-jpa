package com.jpa.onetoone.onetoonejpa.controller;


import com.jpa.onetoone.onetoonejpa.model.Address;
import com.jpa.onetoone.onetoonejpa.model.User;
import com.jpa.onetoone.onetoonejpa.repository.AddressRepository;
import com.jpa.onetoone.onetoonejpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DefaultController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;


    @GetMapping(value = "/users")
    public List<User> getUsers() {

        List<User> users = userRepository.findAll();
       return users;
    }

    @GetMapping(value = "/address")
    public List<Address> getAddress() {

        List<Address> address = addressRepository.findAll();
        return address;
    }

}
