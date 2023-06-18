package org.money.institution.exceptions;

public class InsufficientBalanceException extends BalanceException {

    public InsufficientBalanceException() {
        super(INSUFFICIENT);
    }

}
