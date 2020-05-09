package org.societe.generale.repositories;

import java.util.List;

import org.societe.generale.entities.Account;
import org.societe.generale.exceptions.NotFoundException;

public interface AccountRepository {
	
	Account find(int idClient, int idAccount) throws NotFoundException;
	
	List<Account> findAll(int idClient) throws NotFoundException;
	
	Account save(int idClient, Account account) throws NotFoundException;

}
