package org.money.institution.exceptions;

public class NotFoundException extends Exception {
	
	protected static final String CLIENT_NOT_FOUND = "Client not found";
	protected static final String ACCOUNT_NOT_FOUND = "Account not found";
	protected static final String TRANSACTION_NOT_FOUND = "Transaction not found";
	
	public NotFoundException(String message) {
		super(message);
	}

}
