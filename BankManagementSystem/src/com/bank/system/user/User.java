package com.bank.system.user;

import com.bank.system.account.Account;

import java.math.BigDecimal;

public abstract class User {

    private int userId;
    private String username;
    
    abstract BigDecimal getAccountBalance (Account account);

}
