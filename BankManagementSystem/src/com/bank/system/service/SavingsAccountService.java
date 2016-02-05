package com.bank.system.service;

import com.bank.system.model.account.Account;
import com.bank.system.model.account.SavingsAccount;

import java.math.BigDecimal;

/**
 * Created by shehan on 2/4/16.
 */
public class SavingsAccountService {

    public SavingsAccountService() {
    }

    public void  createSavingsAccount(Account savingsAccount){

    }

    public SavingsAccount getAccountByID(int id){
        return new SavingsAccount(id);
    }

    public void deleteSavingsAccount(String id){

    }

    public void updateSavingsAccount(Account savingsAccount){

    }

    public void reduceBalance(BigDecimal amount){

    }

    public void addBalance(BigDecimal amount){

    }
}
