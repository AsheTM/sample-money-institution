package org.money.institution.exceptions;

public class AccountNotFoundException extends NotFoundException {
	
	public AccountNotFoundException() {
		super(ACCOUNT_NOT_FOUND);
	}

}
