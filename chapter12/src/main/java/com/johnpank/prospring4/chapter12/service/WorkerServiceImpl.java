package com.johnpank.prospring4.chapter12.service;

import com.johnpank.prospring4.chapter12.entity.Worker;
import com.johnpank.prospring4.chapter12.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("workerService")
@Transactional
public class WorkerServiceImpl implements WorkerService{

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Worker> findAll() {
        return new ArrayList<>((Collection<? extends Worker>) workerRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Worker findByName(String name) {
        return workerRepository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Worker findById(Long id) {
        return workerRepository.findById(id).get();
    }

    @Override
    public Worker save(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public void delete(Worker worker) {
        workerRepository.delete(worker);
    }
}
