package org.money.institution.repositories;

import java.util.List;

import org.money.institution.entities.Client;
import org.money.institution.exceptions.ClientNotFoundException;
import org.money.institution.utils.ClientUtil;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositoryImpl extends WalletRepositoryImpl implements ClientRepository {
	
	@Override
	public Client find(int id) throws ClientNotFoundException {
		return ClientUtil.get(id);
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
