package com.johnpank.chapter8.models;

import com.johnpank.chapter8.db.DBContract;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = DBContract.CLIENT_TABLE_NAME)
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DBContract.CLIENT_ID)
    private long id;

    @Column(name = DBContract.CLIENT_LOGIN)
    private String login;

    @Column(name = DBContract.CLIENT_PASSWORD)
    private String password;

    @Column(name = DBContract.CLIENT_TEL_NUMBER)
    private String telNumber;

    @Column(name = DBContract.CLIENT_EMAIL)
    private String email;

    @Temporal(TemporalType.DATE)
    @Column(name = DBContract.CLIENT_BIRTHDAY)
    private Date birthday;

    @OneToMany(targetEntity = Account.class,
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Account> accounts;

    public Client(){}

//    public Client(String login, String password, String telNumber, String email, Date birthday, HashSet<Account> accounts) {
//        this.login = login;
//        this.password = password;
//        this.telNumber = telNumber;
//        this.email = email;
//        this.birthday = birthday;
//        this.accounts = accounts;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public boolean removeAccount(Account account){
        return accounts.remove(account);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", accounts=" + accounts +
                '}';
    }
}
