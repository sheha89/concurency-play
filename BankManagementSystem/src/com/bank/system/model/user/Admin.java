package com.bank.system.model.user;

import com.bank.system.model.account.Account;

import java.math.BigDecimal;

/**
 * Created by shehan on 2/3/16.
 */
public class Admin implements User {

    private static final String customerUserType = "admin";

    private int userId;
    private String username;
    private String password;
    private String userType = customerUserType;

    @Override
    public BigDecimal getAccountBalance(Account account) {
        return null;
    }

    public void createAccount(Account account) {
        // save account to the db

    }

    public void editAccount(Account account) {
        // save account to the db

    }

    public void deleteAccount(Account account) {
        // delete account from the db

    }

}
