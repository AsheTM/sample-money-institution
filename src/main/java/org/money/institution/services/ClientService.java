package org.money.institution.services;

import java.util.List;

import org.money.institution.entities.Client;
import org.money.institution.exceptions.ClientNotFoundException;

public interface ClientService {
	
	Client getClient(int idClient) throws ClientNotFoundException;
	List<Client> getAllClient();
	Client saveClient(Client client);

}
