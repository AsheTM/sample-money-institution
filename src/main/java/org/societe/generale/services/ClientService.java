package org.societe.generale.services;

import java.util.List;

import org.societe.generale.entities.Client;

public interface ClientService {
	
	Client getClient(int idClient);
	
	List<Client> getAllClient();
	
	Client saveClient(Client client);

}
