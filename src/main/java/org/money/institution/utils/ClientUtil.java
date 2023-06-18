package org.money.institution.utils;

import org.money.institution.entities.Client;
import org.money.institution.exceptions.ClientNotFoundException;
import org.money.institution.repositories.WalletRepositoryImpl;

public class ClientUtil implements IEntityUtil<Client> {

	public static Client get(int idC) throws ClientNotFoundException {
		return IEntityUtil.getStream(WalletRepositoryImpl.clients).filter((clt) -> clt.getId() == idC)
				.findFirst()
				.orElseThrow(() -> new ClientNotFoundException());
	}
	
}
