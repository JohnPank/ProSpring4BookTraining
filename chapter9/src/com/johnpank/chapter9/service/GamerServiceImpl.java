package com.johnpank.chapter9.service;

import com.johnpank.chapter9.model.Gamer;
import com.johnpank.chapter9.repository.GamerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("gamerService")
@Transactional
public class GamerServiceImpl implements GamerService {

    @Autowired
    GamerRepository gamerRepository;

    @Transactional(readOnly = true)
    public ArrayList<Gamer> findAllGamers() {
        return (ArrayList<Gamer>) gamerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ArrayList<Gamer> findAllGamersSortedByRating() {
        return (ArrayList<Gamer>) gamerRepository.findAll(new Sort(Sort.Direction.DESC, "rating"));
    }

    @Transactional(readOnly = true)
    public Gamer findByName(String name) {
        return gamerRepository.findByName(name);
    }

    public Gamer findById(Long id) {
        final Gamer gamer = gamerRepository.findById(id).get();
        return gamer;
    }

    public void addNewGamer(Gamer gamer) {
        gamerRepository.save(gamer);
    }

    public void saveGamer(Gamer gamer) {
        gamerRepository.save(gamer);
    }

    public void deleteById(Long id) {
        gamerRepository.deleteById(id);
    }

    public void deleteByName(String name) {
        gamerRepository.deleteByName(name);
    }
}
