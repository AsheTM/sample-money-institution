package org.societe.generale.services;

import java.util.List;

import org.societe.generale.entities.Client;
import org.societe.generale.exceptions.NotFoundException;
import org.societe.generale.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository clientRepository;

	@Override
	public Client getClient(int idClient) {
		Client client = null;
		try {
			client = clientRepository.find(idClient);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return client;
	}

	@Override
	public List<Client> getAllClient() {
		return clientRepository.findAll();
	}
	
	@Override
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}

}
