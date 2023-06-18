package org.money.institution.utils;

import java.util.List;
import java.util.Optional;

import org.money.institution.entities.Client;
import org.money.institution.entities.Transaction;
import org.money.institution.exceptions.NotFoundException;
import org.money.institution.exceptions.TransactionNotFoundException;

public class TransactionUtil implements IEntityUtil<Client> {

	public static Transaction get(List<Transaction> transactions, int idC) throws NotFoundException {
		return IEntityUtil.getStream(transactions).filter((clt) -> clt.getId() == idC).findFirst()
				.orElseThrow(() -> new TransactionNotFoundException());
	}
	
}
