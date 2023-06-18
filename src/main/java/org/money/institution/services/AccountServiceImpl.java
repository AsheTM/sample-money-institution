package org.money.institution.services;

import java.util.List;

import org.money.institution.exceptions.ClientNotFoundException;
import org.money.institution.exceptions.NotFoundException;
import org.money.institution.repositories.AccountRepository;
import org.money.institution.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Override
	public Account getAccount(int idClient, int idAccount) throws NotFoundException {
		return accountRepository.find(idClient, idAccount);
	}
	
	@Override
	public List<Account> getAllAccount(int idClient) throws ClientNotFoundException {
		return accountRepository.findAll(idClient);
	}
	
	@Override
	public Account saveAccount(int idClient) throws ClientNotFoundException {
		return this.accountRepository.save(idClient, new Account());
	}

}
