package org.societe.generale.utils;

import java.util.List;
import java.util.Optional;

import org.societe.generale.entities.Account;
import org.societe.generale.entities.Client;
import org.societe.generale.exceptions.AccountNotFoundException;
import org.societe.generale.exceptions.NotFoundException;

public class AccountUtil implements IEntityUtil<Client> {

	public static Optional<Account> find(List<Account> accounts, int idC) {
		return IEntityUtil.getStream(accounts).filter((clt) -> clt.getId() == idC).findFirst();
	}

	public static Account get(List<Account> accounts, int idC) throws NotFoundException {
		return AccountUtil.find(accounts, idC).orElseThrow(() -> new AccountNotFoundException());
	}

}
