package org.money.institution.exceptions;

public class BalanceException extends Exception {

    protected static final String INSUFFICIENT = "Balance not sufficient";

    public BalanceException(String message) {
        super(message);
    }

}
