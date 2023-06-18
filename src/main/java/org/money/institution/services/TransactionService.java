package org.money.institution.services;

import java.util.List;

import org.money.institution.exceptions.NotFoundException;
import org.money.institution.entities.Transaction;

public interface TransactionService {
	
	Transaction getTransaction(int idClient, int idAccount, int idTransaction) throws NotFoundException;
	List<Transaction> getAllTransaction(int idClient, int idAccount) throws NotFoundException;

}
