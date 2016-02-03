package com.bank.system.user;

import com.bank.system.account.Account;

import java.math.BigDecimal;

/**
 * Created by shehan on 2/3/16.
 */
public class Admin extends User {
    @Override
    BigDecimal getAccountBalance(Account account) {
        return null;
    }

    public void createAccount(Account account){

    }

    public void editAccount(Account account){

    }

    public void deleteAccount(Account account){

    }

}
