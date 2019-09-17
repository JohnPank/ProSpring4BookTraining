package com.johnpank.chapter9.service;

import com.johnpank.chapter9.model.Gamer;

import java.util.ArrayList;

public interface GamerService {

    ArrayList<Gamer> findAllGamers();
    ArrayList<Gamer> findAllGamersSortedByRating();
    Gamer findByName(String name);
    Gamer findById(Long id);
    void addNewGamer(Gamer gamer);
    void saveGamer(Gamer gamer);
    void deleteById(Long id);
    void deleteByName(String name);
}
