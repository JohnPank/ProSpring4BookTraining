package com.johnpank.prospring4.chapter12.repository;

import com.johnpank.prospring4.chapter12.entity.Worker;
import org.springframework.data.repository.CrudRepository;

public interface WorkerRepository extends CrudRepository<Worker, Long> {

    Worker findByName(String name);

}
