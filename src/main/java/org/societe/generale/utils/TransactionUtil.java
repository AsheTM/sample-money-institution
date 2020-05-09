package org.societe.generale.utils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.societe.generale.entities.Client;
import org.societe.generale.entities.Transaction;
import org.societe.generale.exceptions.NotFoundException;
import org.societe.generale.exceptions.TransactionNotFoundException;

public class TransactionUtil implements IEntityUtil<Client> {

	public static Optional<Transaction> find(List<Transaction> transactions, int idC) {
		return IEntityUtil.getStream(transactions).filter((clt) -> clt.getId() == idC).findFirst();
	}

	public static Transaction get(List<Transaction> transactions, int idC) throws NotFoundException {
		return TransactionUtil.find(transactions, idC).orElseThrow(() -> new TransactionNotFoundException());
	}
	
}
