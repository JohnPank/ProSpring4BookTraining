package com.johnpank.prospring4.chapter13.service;

import com.johnpank.prospring4.chapter13.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
    void delete(User user);
    //User findByName(String name);
}
