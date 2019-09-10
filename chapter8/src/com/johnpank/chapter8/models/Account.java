package com.johnpank.chapter8.models;

import com.johnpank.chapter8.db.DBContract;

import javax.persistence.*;

@Entity
@Table(name = DBContract.ACCOUNT_TABLE_NAME)
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DBContract.ACCOUNT_ID)
    private long account_id;

    @Column(name = DBContract.ACCOUNT_CLIENT_ID)
    private long cl_id;

    @Column(name = DBContract.ACCOUNT_BALANCE)
    private long balance;

    @Column(name = DBContract.ACCOUNT_CREDIT)
    private long credit;

    @Column(name = DBContract.ACCOUNT_IS_BLOCKED)
    private boolean isBlocked;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = DBContract.ACCOUNT_CLIENT_ID, insertable = false, updatable = false)
    private Client client;

    public Account(){}

    //region constructor
//        public Account(long cl_id, long balance, long credit, boolean isBlocked, Client client) {
//        this.id = id;
//        this.cl_id = cl_id;
//        this.balance = balance;
//        this.credit = credit;
//        this.isBlocked = isBlocked;
//        this.client = client;
//    }
    //endregion

    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long id) {
        this.account_id = id;
    }


    public long getCl_id() {
        return cl_id;
    }

    public void setCl_id(long cl_id) {
        this.cl_id = cl_id;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getCredit() {
        return credit;
    }

    public void setCredit(long credit) {
        this.credit = credit;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + account_id +
                ", cl_id=" + cl_id +
                ", balance=" + balance +
                ", credit=" + credit +
                ", isBlocked=" + isBlocked +
                ", client=" + client.getLogin() +
                '}';
    }
}
