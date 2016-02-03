package com.bank.system.user;

import com.bank.system.account.Account;

import java.math.BigDecimal;

/**
 * Created by shehan on 2/3/16.
 */
public class Customer extends User {
    @Override
    BigDecimal getAccountBalance(Account account) {
        return null;
    }
}
