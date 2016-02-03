package com.bank.system.model.user;

import com.bank.system.model.account.Account;

import java.math.BigDecimal;

/**
 * Created by shehan on 2/3/16.
 */
public class Customer implements User {

    private static final String customerUserType = "customer";

    private int userId;
    private String username;
    private String password;
    private String userType = customerUserType;

    @Override
    public BigDecimal getAccountBalance(Account account) {
        return null;
    }

}
