package org.money.institution.processes;

import org.money.institution.entities.Account;
import org.money.institution.exceptions.NotFoundException;

public interface AccountProcess {
	
	Account activateAccount(int idClient, int idAccount) throws NotFoundException;
	Account deactivateAccount(int idClient, int idAccount) throws NotFoundException;

}
