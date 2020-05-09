package org.societe.generale.repositories;

import java.util.List;

import org.societe.generale.entities.Transaction;
import org.societe.generale.exceptions.NotFoundException;

public interface TransactionRepository {
	
	Transaction find(int idClient, int idAccount, int idTransaction) throws NotFoundException;
	
	List<Transaction> findAll(int idClient, int idAccount) throws NotFoundException;

}
