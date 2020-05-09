package org.societe.generale.utils;

import java.util.List;
import java.util.Optional;

import org.societe.generale.entities.Client;
import org.societe.generale.exceptions.ClientNotFoundException;
import org.societe.generale.exceptions.NotFoundException;

public class ClientUtil implements IEntityUtil<Client> {

	public static Optional<Client> find(List<Client> clients, int idC) {
		return IEntityUtil.getStream(clients).filter((clt) -> clt.getId() == idC).findFirst();
	}

	public static Client get(List<Client> clients, int idC) throws ClientNotFoundException {
		return ClientUtil.find(clients, idC).orElseThrow(() -> new ClientNotFoundException());
	}
	
}
