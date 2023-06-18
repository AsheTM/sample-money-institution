package org.money.institution.views;

import org.money.institution.entities.Client;

public class ClientRequestView implements IRequestView {

    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setClient(Client client) {
        this.fullName = client.getFullName();
    }

    public void setClient(String fullName) {
        this.fullName = fullName;
    }

    public static Client to(ClientRequestView clientRequestView) {
        return new Client(clientRequestView.getFullName());
    }
}
