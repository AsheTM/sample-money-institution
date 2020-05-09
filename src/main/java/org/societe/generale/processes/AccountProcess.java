package org.societe.generale.processes;

import org.societe.generale.entities.Account;

public interface AccountProcess {
	
	Account activateAccount(Account account);
	
	Account deactivateAccount(Account account);

}
