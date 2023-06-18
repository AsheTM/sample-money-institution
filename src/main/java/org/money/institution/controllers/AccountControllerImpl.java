package org.money.institution.controllers;

import java.util.List;

import org.money.institution.exceptions.InsufficientBalanceException;
import org.money.institution.exceptions.ClientNotFoundException;
import org.money.institution.exceptions.NotFoundException;
import org.money.institution.processes.AccountProcess;
import org.money.institution.processes.WalletProcess;
import org.money.institution.entities.Account;
import org.money.institution.entities.Transaction;
import org.money.institution.services.AccountService;
import org.money.institution.views.AccountResponseView;
import org.money.institution.views.AccountsResponseView;
import org.money.institution.views.TransactionRequestView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountControllerImpl implements WalletController.AccountController {
	
	private AccountService accountService;
	private AccountProcess accountProcess;
	private WalletProcess walletProcess;
	
	@Autowired
	public AccountControllerImpl(AccountService accountService, 
			AccountProcess accountProcess, 
			WalletProcess walletProcess) {
		this.accountService = accountService;
		this.accountProcess = accountProcess;
		this.walletProcess = walletProcess;
	}

	@Override
	public AccountsResponseView showAccounts(int idClient) throws ClientNotFoundException {
		List<Account> accounts = this.accountService.getAllAccount(idClient);
		
		return AccountsResponseView.from(accounts);
	}

	@Override
	public AccountResponseView showAccount(int idClient, int idAccount) throws NotFoundException {
		Account account = this.accountService.getAccount(idClient, idAccount);
		
		return AccountResponseView.from(account);
	}

	@Override
	public AccountResponseView addAccount(int idClient) throws ClientNotFoundException {
		Account account = this.accountService.saveAccount(idClient);

		return AccountResponseView.from(account);
	}

	@Override
	public AccountResponseView withdraw(int idClient, int idAccount, TransactionRequestView transactionRequestView)
			throws InsufficientBalanceException, NotFoundException {
		Transaction transaction = TransactionRequestView.to(transactionRequestView);
		Account account = this.walletProcess.withdraw(idClient, idAccount, transaction);
		
		return AccountResponseView.from(account);
	}

	@Override
	public AccountResponseView deposit(int idClient, int idAccount, TransactionRequestView transactionRequestView)
			throws NotFoundException {
		Transaction transaction = TransactionRequestView.to(transactionRequestView);
		Account account = this.walletProcess.deposit(idClient, idAccount, transaction);
		
		return AccountResponseView.from(account);
	}

	@Override
	public AccountResponseView activateAccount(int idClient, int idAccount) throws NotFoundException {
		Account account = this.accountProcess.activateAccount(idClient, idAccount);
		
		return AccountResponseView.from(account);
	}

	@Override
	public AccountResponseView deactivateAccount(int idClient, int idAccount) throws NotFoundException {
		Account account = this.accountProcess.deactivateAccount(idClient, idAccount);
		
		return AccountResponseView.from(account);
	}

}
