package org.money.institution.utils;

import java.util.List;
import java.util.Optional;

import org.money.institution.entities.Account;
import org.money.institution.entities.Client;
import org.money.institution.exceptions.AccountNotFoundException;
import org.money.institution.exceptions.NotFoundException;

public class AccountUtil implements IEntityUtil<Client> {

	public static Account get(List<Account> accounts, int idC) throws NotFoundException {
		return IEntityUtil.getStream(accounts).filter((clt) -> clt.getId() == idC).findFirst()
				.orElseThrow(() -> new AccountNotFoundException());
	}

}
