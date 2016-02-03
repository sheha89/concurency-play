package com.bank.system.model.account;

import java.math.BigDecimal;

/**
 * Created by shehan on 2/3/16.
 */
public class FixedAccount extends Account {

    @Override
    public BigDecimal calculateInterest(BigDecimal accountBalance) {
        return null;
    }

    @Override
    public void updateAccountBalance(BigDecimal accountBalance, BigDecimal interest) {

    }
}
