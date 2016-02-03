package com.bank.system.model.user;

import com.bank.system.model.account.Account;

import java.math.BigDecimal;

public interface User {

    BigDecimal getAccountBalance(Account account);

}
