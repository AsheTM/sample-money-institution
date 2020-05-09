package org.societe.generale.repositories;

import java.util.List;

import org.societe.generale.entities.Account;
import org.societe.generale.entities.Client;
import org.societe.generale.exceptions.ClientNotFoundException;
import org.societe.generale.exceptions.NotFoundException;
import org.societe.generale.utils.AccountUtil;
import org.societe.generale.utils.ClientUtil;
import org.springframework.stereotype.Repository;

@Repository
public class AccountRepositoryImpl extends WalletRepositoryImpl implements AccountRepository {

	@Override
	public Account find(int idClient, int idAccount) throws NotFoundException {
		List<Account> accounts = this.findAll(idClient);
		return AccountUtil.get(accounts, idAccount);
	}

	@Override
	public List<Account> findAll(int idClient) throws ClientNotFoundException {
		Client client = ClientUtil.get(clients, idClient);
		return client.getAccounts();
	}
	
	@Override
	public Account save(int idClient, Account account) throws ClientNotFoundException {
		Client client = ClientUtil.get(clients, idClient);
		client.setAccount(account);
		
		return account;
	}

}
