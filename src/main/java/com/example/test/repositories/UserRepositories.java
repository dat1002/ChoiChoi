package com.example.test.repositories;

import com.example.test.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepositories extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    User findByName(String name);
    Set<User> findAllByName(String name);
    User findByAccount(String account);
}
