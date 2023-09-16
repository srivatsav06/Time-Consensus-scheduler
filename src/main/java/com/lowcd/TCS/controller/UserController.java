package com.lowcd.TCS.controller;

import com.lowcd.TCS.entity.User;
import com.lowcd.TCS.model.LoginBO;
import com.lowcd.TCS.model.UserBO;
import com.lowcd.TCS.repository.RoleRepository;
import com.lowcd.TCS.repository.UserRepository;
import com.lowcd.TCS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/user")


public class UserController {

    @Autowired
    private UserService userservice;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;

    /**
     * Endpoint for saving a new user or returning an error if the email already exists.
     *
     * @param userBO The UserBO object containing user data to be saved.
     * @return ResponseEntity containing a success message or error message and the corresponding HTTP status.
     */
    @PostMapping(path = "/save")
    public ResponseEntity<Object> saveUser(@RequestBody UserBO userBO) {

        User user = userRepository.findByEmail(userBO.getEmail());
        if (user != null) {
            String id = "Email ready exists!";
            return new ResponseEntity<>(id, HttpStatus.ALREADY_REPORTED);
        }

        String id = userservice.addUser(userBO);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    /**
     * Endpoint for user login.
     *
     * @param loginuser The LoginBO object containing login credentials (email and password).
     * @return ResponseEntity containing a login status message and HTTP status.
     */
    @PostMapping(path = "/login")
    public ResponseEntity<Object> loginemployee(@RequestBody LoginBO loginuser) {
        String st = userservice.loginEmployee(loginuser);
        return new ResponseEntity<>(st, HttpStatus.FOUND);
    }

}
