package org.money.institution.repositories;

import java.util.List;

import org.money.institution.exceptions.NotFoundException;
import org.money.institution.entities.Account;
import org.money.institution.entities.Client;
import org.money.institution.exceptions.ClientNotFoundException;
import org.money.institution.utils.AccountUtil;
import org.money.institution.utils.ClientUtil;
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
		Client client = ClientUtil.get(idClient);

		return client.getAccounts();
	}
	
	@Override
	public Account save(int idClient, Account account) throws ClientNotFoundException {
		Client client = ClientUtil.get(idClient);

		client.setAccount(account);
		
		return account;
	}

}
