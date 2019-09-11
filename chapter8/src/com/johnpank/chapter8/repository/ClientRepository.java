package com.johnpank.chapter8.repository;

import com.johnpank.chapter8.models.Client;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    //some magic
    Client findByLogin(String login);

}
