package org.money.institution.views;

import java.util.List;

import org.money.institution.entities.Client;

public class ClientsResponseView implements IResponseView {
	
	private List<Client> clients;

	public ClientsResponseView() {
	}

	public ClientsResponseView(List<Client> clients) {
		super();
		this.clients = clients;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	public static ClientsResponseView from(List<Client> clients) {
		return new ClientsResponseView(clients);
	}

}
