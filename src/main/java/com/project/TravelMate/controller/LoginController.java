package com.project.TravelMate.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.TravelMate.model.User;
import com.project.TravelMate.service.UserService;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        Optional<User> existingUser = userService.findUser(
            user.getFirstname(), user.getLastname(), user.getPhoneno(), user.getEmail()
        );

        if (existingUser.isPresent()) {
            return ResponseEntity.ok("Login successful for user: " + user.getFirstname() + " " + user.getLastname());
        } else {
            // You can choose to save a new user on login attempt or handle it differently
            userService.saveUser(user);
            return ResponseEntity.status(201).body("User created and logged in: " + user.getFirstname() + " " + user.getLastname());
        }
    }
    
    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);

        if (savedUser!=null) {
            return ResponseEntity.ok("Login successful for user: " + user.getFirstname() + " " + user.getLastname());
        } else {
            // You can choose to save a new user on login attempt or handle it differently
            userService.saveUser(user);
            return ResponseEntity.status(201).body("User created and logged in: " + user.getFirstname() + " " + user.getLastname());
        }
    }
}
