package org.money.institution.processes;

import org.money.institution.entities.Account;
import org.money.institution.entities.Transaction;
import org.money.institution.exceptions.InsufficientBalanceException;
import org.money.institution.exceptions.NotFoundException;

public interface WalletProcess {
	
	Account withdraw(int idClient, int idAccount, Transaction transaction)
			throws InsufficientBalanceException, NotFoundException;
	Account deposit(int idClient, int idAccount, Transaction transaction) throws NotFoundException;

}
