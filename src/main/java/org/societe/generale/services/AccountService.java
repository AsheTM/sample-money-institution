package org.societe.generale.services;

import java.util.List;

import org.societe.generale.entities.Account;

public interface AccountService {
	
	Account getAccount(int idClient, int idAccount);
	
	List<Account> getAllAccount(int idClient);
	
	Account saveAccount(int idClient, Account account);

}
