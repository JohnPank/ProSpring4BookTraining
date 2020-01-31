package com.johnpank.prospring4.chapter12.service;

import com.johnpank.prospring4.chapter12.entity.Worker;

import java.util.List;

public interface WorkerService {
    List<Worker> findAll();
    Worker findByName(String name);
    Worker findById(Long id);
    Worker save(Worker worker);
    void delete(Worker worker);
}
