package org.money.institution.views;

import org.money.institution.entities.Client;

public class ClientResponseView implements IResponseView {
	
	private Client client;

	public ClientResponseView() {
	}

	public ClientResponseView(Client client) {
		super();
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public static ClientResponseView from(Client client) {
		return new ClientResponseView(client);
	}

}
