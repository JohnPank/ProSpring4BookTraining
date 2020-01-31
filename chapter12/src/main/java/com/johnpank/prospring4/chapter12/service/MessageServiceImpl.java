package com.johnpank.prospring4.chapter12.service;

import com.johnpank.prospring4.chapter12.entity.Message;
import com.johnpank.prospring4.chapter12.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("messageService")
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Message> findAll() {
        return (List<Message>) messageRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Message> findByWorkerId(Long id) {
        return messageRepository.findByWorkerId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Message findById(Long id) {
        return messageRepository.findById(id).get();
    }

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public void delete(Message message) {
        messageRepository.delete(message);
    }
}
