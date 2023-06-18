package org.money.institution.services;

import java.util.List;

import org.money.institution.exceptions.ClientNotFoundException;
import org.money.institution.exceptions.NotFoundException;
import org.money.institution.repositories.ClientRepository;
import org.money.institution.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
    ClientRepository clientRepository;

	@Override
	public Client getClient(int idClient) throws ClientNotFoundException {
		return clientRepository.find(idClient);
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
