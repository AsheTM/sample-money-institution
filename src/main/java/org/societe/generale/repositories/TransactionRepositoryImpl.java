package org.societe.generale.repositories;

import java.util.List;

import org.societe.generale.entities.Account;
import org.societe.generale.entities.Client;
import org.societe.generale.entities.Transaction;
import org.societe.generale.exceptions.AccountNotFoundException;
import org.societe.generale.exceptions.ClientNotFoundException;
import org.societe.generale.exceptions.NotFoundException;
import org.societe.generale.exceptions.TransactionNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionRepositoryImpl extends WalletRepositoryImpl implements TransactionRepository {

	@Override
	public Transaction find(int idClient, int idAccount, int idTransaction) throws NotFoundException {
		List<Transaction> transactions = this.findAll(idClient, idAccount);
		return transactions.stream().filter(trs -> trs.getId() == idTransaction)
				.findFirst()
				.orElseThrow(() -> new TransactionNotFoundException());
	}

	@Override
	public List<Transaction> findAll(int idClient, int idAccount) throws NotFoundException {
		Client client = clients.stream().filter(clt -> clt.getId() == idClient)
				.findFirst()
				.orElseThrow(() -> new ClientNotFoundException());
		Account account = client.getAccounts().stream().filter(acc -> acc.getId() == idAccount)
				.findFirst()
				.orElseThrow(() -> new AccountNotFoundException());
		return account.getTransactions();
	}

}
