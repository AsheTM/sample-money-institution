package org.money.institution.controllers;

import java.util.List;

import org.money.institution.exceptions.NotFoundException;
import org.money.institution.services.TransactionService;
import org.money.institution.entities.Transaction;
import org.money.institution.views.TransactionResponseView;
import org.money.institution.views.TransactionsResponseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionControllerImpl implements WalletController.TransactionController {
	
	private TransactionService transactionService;
	
	@Autowired
	public TransactionControllerImpl(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@Override
	public TransactionsResponseView showTransactions(int idClient, int idAccount) throws NotFoundException {
		List<Transaction> transactions = this.transactionService.getAllTransaction(idClient, idAccount);
		
		return TransactionsResponseView.from(transactions);
	}

	@Override
	public TransactionResponseView showTransaction(int idClient, int idAccount, int idTransaction)
			throws NotFoundException {
		Transaction transaction = this.transactionService.getTransaction(idClient, idAccount, idTransaction);
		
		return TransactionResponseView.from(transaction);
	}

}
