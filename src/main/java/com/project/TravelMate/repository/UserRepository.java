package com.project.TravelMate.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.TravelMate.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByFirstnameAndLastnameAndPhonenoAndEmail(
        String firstname, String lastname, String phoneno, String email
    );
}
