package org.societe.generale.controllers;

import java.util.List;

import org.societe.generale.entities.Transaction;
import org.societe.generale.exceptions.NotFoundException;
import org.societe.generale.services.TransactionService;
import org.societe.generale.views.TransactionResponseView;
import org.societe.generale.views.TransactionsResponseView;
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
