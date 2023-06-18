package org.money.institution.services;

import java.util.List;

import org.money.institution.exceptions.NotFoundException;
import org.money.institution.repositories.TransactionRepository;
import org.money.institution.entities.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
	
	@Autowired
    TransactionRepository transactionRepository;

	@Override
	public Transaction getTransaction(int idClient, int idAccount, int idTransaction) throws NotFoundException {
		return transactionRepository.find(idClient, idAccount, idTransaction);
	}

	@Override
	public List<Transaction> getAllTransaction(int idClient, int idAccount) throws NotFoundException {
		return transactionRepository.findAll(idClient, idAccount);
	}

}
