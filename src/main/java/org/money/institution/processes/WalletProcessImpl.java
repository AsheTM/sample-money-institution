package org.money.institution.processes;

import java.math.BigDecimal;

import org.aspectj.lang.annotation.Before;
import org.money.institution.entities.Account;
import org.money.institution.entities.Transaction;
import org.money.institution.exceptions.InsufficientBalanceException;
import org.money.institution.exceptions.NotFoundException;
import org.money.institution.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WalletProcessImpl implements WalletProcess {

	private AccountService accountService;

	@Autowired
	public WalletProcessImpl(AccountService accountService) {
		this.accountService = accountService;
	}

	@Before("execution(public * *(..)")
	@Override
	public Account withdraw(int idClient, int idAccount, Transaction transaction)
			throws InsufficientBalanceException, NotFoundException {
		Account account = this.accountService.getAccount(idClient, idAccount);
		BigDecimal amount = transaction.getAmount().abs().negate();

		transaction.setAmount(amount);
		account.getTransactions().add(transaction);
		
		BigDecimal money = account.getBalance();
		BigDecimal balance = money.add(amount);

		if(balance.longValue() < 0) {
			throw new InsufficientBalanceException();
		}

		account.setBalance(balance);
		
		return account;
	}

	@Before("execution(public * *(..)")
	@Override
	public Account deposit(int idClient, int idAccount, Transaction transaction) throws NotFoundException {
		Account account = this.accountService.getAccount(idClient, idAccount);
		BigDecimal amount = transaction.getAmount().abs();

		transaction.setAmount(amount);
		account.getTransactions().add(transaction);
		
		BigDecimal money = account.getBalance();
		BigDecimal balance = money.add(amount);

		account.setBalance(balance);
		
		return account;
	}

}
