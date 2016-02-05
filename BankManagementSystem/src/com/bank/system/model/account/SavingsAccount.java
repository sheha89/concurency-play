package com.bank.system.model.account;

import java.math.BigDecimal;

/**
 * Created by shehan on 2/3/16.
 */
public class SavingsAccount extends Account {

    public SavingsAccount(int accountNumber) {
        super(accountNumber);
    }

    @Override
    public BigDecimal calculateInterest(BigDecimal accountBalance) {
        //calculation
        return null;
    }

    @Override
    public void updateAccountBalance(BigDecimal accountBalance, BigDecimal interest) {

    }
}
