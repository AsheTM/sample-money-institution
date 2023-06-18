package org.money.institution.repositories;

import java.util.List;

import org.money.institution.exceptions.NotFoundException;
import org.money.institution.exceptions.TransactionNotFoundException;
import org.money.institution.entities.Account;
import org.money.institution.entities.Client;
import org.money.institution.entities.Transaction;
import org.money.institution.exceptions.AccountNotFoundException;
import org.money.institution.exceptions.ClientNotFoundException;
import org.money.institution.utils.AccountUtil;
import org.money.institution.utils.ClientUtil;
import org.money.institution.utils.TransactionUtil;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepositoryImpl extends WalletRepositoryImpl implements TransactionRepository {

	@Override
	public Transaction find(int idClient, int idAccount, int idTransaction) throws NotFoundException {
		List<Transaction> transactions = this.findAll(idClient, idAccount);

		return TransactionUtil.get(transactions, idTransaction);
	}

	@Override
	public List<Transaction> findAll(int idClient, int idAccount) throws NotFoundException {
		Client client = ClientUtil.get(idClient);
		Account account = AccountUtil.get(client.getAccounts(), idAccount);

		return account.getTransactions();
	}

}
