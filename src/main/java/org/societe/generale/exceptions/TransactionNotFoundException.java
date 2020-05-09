package org.societe.generale.exceptions;

public class TransactionNotFoundException extends NotFoundException {
	
	public TransactionNotFoundException() {
		super(TRANSACTION_NOT_FOUND);
	}
	
}
