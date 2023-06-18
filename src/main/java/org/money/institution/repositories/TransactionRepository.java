package org.money.institution.repositories;

import java.util.List;

import org.money.institution.entities.Transaction;
import org.money.institution.exceptions.NotFoundException;

public interface TransactionRepository {
	
	Transaction find(int idClient, int idAccount, int idTransaction) throws NotFoundException;
	List<Transaction> findAll(int idClient, int idAccount) throws NotFoundException;

}
