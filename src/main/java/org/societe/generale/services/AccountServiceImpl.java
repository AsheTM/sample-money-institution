package org.societe.generale.services;

import java.util.List;

import org.societe.generale.entities.Account;
import org.societe.generale.exceptions.NotFoundException;
import org.societe.generale.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public Account getAccount(int idClient, int idAccount) {
		Account account = null;
		try {
			account = accountRepository.find(idClient, idAccount);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return account;
	}
	
	@Override
	public List<Account> getAllAccount(int idClient) {
		List<Account> accounts = null;
		try {
			accounts = accountRepository.findAll(idClient);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return accounts;
	}
	
	@Override
	public Account saveAccount(int idClient, Account account) {
		try {
			this.accountRepository.save(idClient, account);
		} catch(NotFoundException e) {
			account = null;
			e.printStackTrace();
		}
		return account;
	}

}
