package org.societe.generale.controllers;

import java.util.List;

import org.societe.generale.entities.Client;
import org.societe.generale.exceptions.NotFoundException;
import org.societe.generale.services.ClientService;
import org.societe.generale.views.ClientResponseView;
import org.societe.generale.views.ClientsResponseView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientControllerImpl implements WalletController.ClientController {

	private ClientService clientService;
	
	@Autowired
	public ClientControllerImpl(ClientService clientService) {
		this.clientService = clientService;
	}

	@Override
	public ClientsResponseView showClients() throws NotFoundException {
		List<Client> clients = this.clientService.getAllClient();
		
		return ClientsResponseView.from(clients);
	}

	@Override
	public ClientResponseView showClient(int idClient) throws NotFoundException {
		Client client = this.clientService.getClient(idClient);
		
		return ClientResponseView.from(client);
	}

	@Override
	public ClientResponseView addClient(Client client) throws NotFoundException {
		client = this.clientService.saveClient(client);
		
		return ClientResponseView.from(client);
	}
	
}
