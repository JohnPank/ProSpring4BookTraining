package com.johnpank.chapter8;

import com.johnpank.chapter8.models.Account;

public class AccGenerator {

    public Account getAccount(){
        Account account = new Account();

        account.setBalance((int)Math.round(Math.random() * 1000000));
        account.setCredit((int)Math.round(Math.random() * 100) * 1000);
        account.setBlocked(getBool());

        return account;
    }

    private boolean getBool() {
        int temp = (int)Math.round(Math.random()*100);
        if (temp < 85) return false;
        return true;
    }
}
