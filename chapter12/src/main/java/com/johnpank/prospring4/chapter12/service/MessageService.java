package com.johnpank.prospring4.chapter12.service;

import com.johnpank.prospring4.chapter12.entity.Message;

import java.util.List;

public interface MessageService {

    List<Message> findAll();
    List<Message> findByWorkerId(Long id);
    Message findById(Long id);
    Message save(Message message);
    void delete(Message message);
}
