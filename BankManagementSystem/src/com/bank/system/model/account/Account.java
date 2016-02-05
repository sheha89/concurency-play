package com.bank.system.model.account;

import java.math.BigDecimal;

public abstract class Account {

    private String accountId;
    private int accountNumber;
    private String accountOwner;
    private BigDecimal accountBalance;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        accountBalance = BigDecimal.valueOf(0);
    }

    public void credit(BigDecimal amount) {
        System.out.println("start credit");
        synchronized (this) {
            this.accountBalance = this.accountBalance.add(amount);
        }
        System.out.println("end credit");
    }

    public void debit(BigDecimal amount) {
        System.out.println("start debit");
        synchronized (this) {
//        if (accountBalance. < amount) {
//            System.out.println("amount withdrawn exceeds the current balance!");
//        } else {
//            accountBalance -= amount;
//        }
        }
        System.out.println("end credit");
    }


    abstract BigDecimal calculateInterest(BigDecimal accountBalance);

    abstract void updateAccountBalance(BigDecimal accountBalance, BigDecimal interest);


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
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
