package org.money.institution.exceptions;

public class ClientNotFoundException extends NotFoundException {
	
	public ClientNotFoundException() {
		super(CLIENT_NOT_FOUND);
	}

}
