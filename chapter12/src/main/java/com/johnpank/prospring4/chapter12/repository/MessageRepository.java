package com.johnpank.prospring4.chapter12.repository;

import com.johnpank.prospring4.chapter12.entity.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {

    List<Message> findByWorkerId(Long id);
}
