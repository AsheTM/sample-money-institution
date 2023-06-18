package org.money.institution.repositories;

import java.util.List;

import org.money.institution.entities.Account;
import org.money.institution.exceptions.ClientNotFoundException;
import org.money.institution.exceptions.NotFoundException;

public interface AccountRepository {
	
	Account find(int idClient, int idAccount) throws NotFoundException;
	List<Account> findAll(int idClient) throws ClientNotFoundException;
	Account save(int idClient, Account account) throws ClientNotFoundException;

}
