package com.bank.system.model.transaction;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by shehan on 2/5/16.
 */
public class Transaction {
    private BigDecimal amount;
    private BigDecimal transactionType;
    private Date transactionDate;

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(BigDecimal transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
