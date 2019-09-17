package com.johnpank.chapter8;

import com.johnpank.chapter8.models.Account;
import com.johnpank.chapter8.models.Client;
import com.johnpank.chapter8.repository.ClientRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainClass {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ClientRepository clientRepository = context.getBean(ClientRepository.class);
        //AccountRepository accountRepository = context.getBean(AccountRepository.class);

        System.out.println("Start");

        //region create 1000 clients

//        for (int i = 0; i < 1000; i++) {
//            Client client = new ClientGenerator().getClient();
//            clientRepository.save(client);
//            //how many accounts have client
//            int counter = (int)Math.round(Math.random()*5);
//
//            HashSet<Account> accounts = new HashSet<>();
//            for (int j = 0; j < counter; j++) {
//                Account account = new AccGenerator().getAccount();
//                account.setCl_id(client.getId());
//                account.setClient(client);
//                accounts.add(account);
//            }
//            client.setAccounts(accounts);
//            clientRepository.save(client);
//        }

        //endregion

        //Optional<Client>  clientOptional = clientRepository.findById(359L);
        //Client client = clientOptional.get();

        Client client = clientRepository.findByLogin("ЖеняКрымский");
        System.out.println(client);

        int totalBalanse = 0;

        for (Account account : client.getAccounts()){
            System.out.println("balance = " + account.getBalance());
            totalBalanse += account.getBalance();
        }


        System.out.println("Total = " + totalBalanse);



//        Client client;
//        client = new Client();
//        client.setLogin("SomeClient4");
//        client.setPassword("1234567890");
//        client.setEmail("cl@mail.ru");
//        client.setTelNumber("89103571245");
//        client.setBirthday(new Date(1225555564));
//
//        Client persistClient = clientRepository.save(client);
//
//
//        Account account1 = new Account();
//        account1.setBalance(1666);
//        account1.setCl_id(persistClient.getId());
//        account1.setBlocked(false);
//        account1.setClient(client);
//
//        HashSet<Account> accounts = new HashSet<Account>(Arrays.asList(new Account[]{account1}));
//
//        client.setAccounts(accounts);
//        System.out.println(client);
//
//        clientRepository.save(client);
//
//
//        //clientRepository.delete(client);

        System.out.println("End");

        context.close();
    }
}
