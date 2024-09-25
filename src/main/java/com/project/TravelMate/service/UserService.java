package com.project.TravelMate.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.TravelMate.model.User;
import com.project.TravelMate.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findUser(String firstname, String lastname, String phoneno, String email) {
        return userRepository.findByFirstnameAndLastnameAndPhonenoAndEmail(firstname, lastname, phoneno, email);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
