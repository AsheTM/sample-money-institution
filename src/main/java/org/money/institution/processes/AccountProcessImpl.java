package org.money.institution.processes;

import org.money.institution.entities.Account;
import org.money.institution.exceptions.NotFoundException;
import org.money.institution.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountProcessImpl implements AccountProcess {

	private AccountService accountService;

	@Autowired
	public AccountProcessImpl(AccountService accountService) {
		this.accountService = accountService;
	}

	@Override
	public Account activateAccount(int idClient, int idAccount) throws NotFoundException {
		Account account = this.accountService.getAccount(idClient, idAccount);

		account.setActivate(true);
		
		return account;
	}

	@Override
	public Account deactivateAccount(int idClient, int idAccount) throws NotFoundException {
		Account account = this.accountService.getAccount(idClient, idAccount);

		account.setActivate(false);
		
		return account;
	}
	
	

}
