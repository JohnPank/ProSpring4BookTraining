package com.johnpank.chapter8;

import com.johnpank.chapter8.models.Account;
import com.johnpank.chapter8.models.Client;
import com.johnpank.chapter8.repository.AccountRepository;
import com.johnpank.chapter8.repository.ClientRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;

public class MainClass {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ClientRepository clientRepository = context.getBean(ClientRepository.class);
        //AccountRepository accountRepository = context.getBean(AccountRepository.class);

        System.out.println("Start");

        Client client;
        client = new Client();
        client.setLogin("SomeClient4");
        client.setPassword("1234567890");
        client.setEmail("cl@mail.ru");
        client.setTelNumber("89103571245");
        client.setBirthday(new Date(1225555564));

        Client persistClient = clientRepository.save(client);


        Account account1 = new Account();
        account1.setBalance(1666);
        account1.setCl_id(persistClient.getId());
        account1.setBlocked(false);
        account1.setClient(client);

        HashSet<Account> accounts = new HashSet<Account>(Arrays.asList(new Account[]{account1}));

        client.setAccounts(accounts);
        System.out.println(client);

        clientRepository.save(client);

        Optional<Client>  clientOptional = clientRepository.findById(19L);
        client = clientOptional.get();

        System.out.println(client);
        //clientRepository.delete(client);

        System.out.println("End");

        context.close();
    }
}
