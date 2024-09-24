package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        Map<String, String> response = new HashMap<>();
        if (userService.validateUser(email, password)) {
            response.put("message", "Login successful!");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Invalid email or password!");
            return ResponseEntity.status(401).body(response);
        }
    }
}
