package com.johnpank.prospring4.chapter13.repository;

import com.johnpank.prospring4.chapter13.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    //User findByName(String name);
}
