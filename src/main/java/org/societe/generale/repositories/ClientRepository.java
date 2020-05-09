package org.societe.generale.repositories;

import java.util.List;

import org.societe.generale.entities.Client;
import org.societe.generale.exceptions.NotFoundException;

public interface ClientRepository {
	
	Client find(int id) throws NotFoundException;
	
	List<Client> findAll();
	
	Client save(Client client);

}
