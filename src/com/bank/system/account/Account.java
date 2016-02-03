package com.bank.system.account;

import java.math.BigDecimal;

public abstract class Account {

    private String accountId;
    private String accountNumber;
    private String accountOwner;
    private BigDecimal accountBalance;

    abstract void deposit();
    abstract void withdraw();
    abstract BigDecimal calculate();



    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

}
