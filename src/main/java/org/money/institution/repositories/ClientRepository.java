package org.money.institution.repositories;

import java.util.List;

import org.money.institution.entities.Client;
import org.money.institution.exceptions.ClientNotFoundException;
import org.money.institution.exceptions.NotFoundException;

public interface ClientRepository {
	
	Client find(int id) throws ClientNotFoundException;
	List<Client> findAll();
	Client save(Client client);

}
