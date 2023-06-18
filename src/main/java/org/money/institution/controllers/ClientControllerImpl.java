package org.money.institution.controllers;

import java.util.List;

import org.money.institution.exceptions.NotFoundException;
import org.money.institution.entities.Client;
import org.money.institution.services.ClientService;
import org.money.institution.views.ClientRequestView;
import org.money.institution.views.ClientResponseView;
import org.money.institution.views.ClientsResponseView;
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
	public ClientsResponseView showClients() {
		List<Client> clients = this.clientService.getAllClient();
		
		return ClientsResponseView.from(clients);
	}

	@Override
	public ClientResponseView showClient(int idClient) throws NotFoundException {
		Client client = this.clientService.getClient(idClient);
		
		return ClientResponseView.from(client);
	}

	@Override
	public ClientResponseView addClient(ClientRequestView clientRequestView) {
		Client client = this.clientService.saveClient(ClientRequestView.to(clientRequestView));
		
		return ClientResponseView.from(client);
	}
	
}
