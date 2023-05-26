package com.example.simplerestapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.simplerestapi.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
