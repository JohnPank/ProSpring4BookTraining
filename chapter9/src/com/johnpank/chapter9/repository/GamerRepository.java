package com.johnpank.chapter9.repository;

import com.johnpank.chapter9.model.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GamerRepository extends JpaRepository<Gamer, Long> {

    Gamer findByName(String name);
    void deleteByName(String name);
}
