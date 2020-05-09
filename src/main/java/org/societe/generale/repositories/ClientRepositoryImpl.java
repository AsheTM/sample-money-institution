package org.societe.generale.repositories;

import java.util.List;

import org.societe.generale.entities.Client;
import org.societe.generale.exceptions.ClientNotFoundException;
import org.societe.generale.utils.ClientUtil;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositoryImpl extends WalletRepositoryImpl implements ClientRepository {
	
	@Override
	public Client find(int id) throws ClientNotFoundException {
		return ClientUtil.get(clients, id);
	}

	@Override
	public List<Client> findAll() {
		return clients;
	}
	
	@Override
	public Client save(Client client) {
		clients.add(client);
		
		return client;
	}

}
