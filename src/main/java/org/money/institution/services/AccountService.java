package org.money.institution.services;

import java.util.List;

import org.money.institution.entities.Account;
import org.money.institution.exceptions.ClientNotFoundException;
import org.money.institution.exceptions.NotFoundException;

public interface AccountService {
	
	Account getAccount(int idClient, int idAccount) throws NotFoundException;
	List<Account> getAllAccount(int idClient) throws ClientNotFoundException;
	Account saveAccount(int idClient) throws ClientNotFoundException;

}
