package org.societe.generale.services;

import java.util.List;

import org.societe.generale.entities.Transaction;
import org.societe.generale.exceptions.NotFoundException;

public interface TransactionService {
	
	Transaction getTransaction(int idClient, int idAccount, int idTransaction) throws NotFoundException;
	
	List<Transaction> getAllTransaction(int idClient, int idAccount) throws NotFoundException;

}
