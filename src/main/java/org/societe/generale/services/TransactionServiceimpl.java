package org.societe.generale.services;

import java.util.List;

import org.societe.generale.entities.Transaction;
import org.societe.generale.exceptions.NotFoundException;
import org.societe.generale.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceimpl implements TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public Transaction getTransaction(int idClient, int idAccount, int idTransaction) {
		Transaction transaction = null;
		try {
			transaction = transactionRepository.find(idClient, idAccount, idTransaction);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return transaction;
	}

	@Override
	public List<Transaction> getAllTransaction(int idClient, int idAccount) {
		List<Transaction> transactions = null;
		try {
			transactions = transactionRepository.findAll(idClient, idAccount);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return transactions;
	}

}
