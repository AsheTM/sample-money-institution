package org.money.institution.views;

import org.money.institution.entities.Transaction;

import java.math.BigDecimal;

public class TransactionRequestView implements IRequestView {

    private BigDecimal amount;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public static Transaction to(TransactionRequestView transactionResponseView) {
        return new Transaction(transactionResponseView.getAmount());
    }
}
