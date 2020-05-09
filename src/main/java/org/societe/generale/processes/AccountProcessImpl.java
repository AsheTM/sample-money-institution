package org.societe.generale.processes;

import org.societe.generale.entities.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountProcessImpl implements AccountProcess {

	@Override
	public Account activateAccount(Account account) {
		account.setActivate(true);
		
		return account;
	}

	@Override
	public Account deactivateAccount(Account account) {
		account.setActivate(false);
		
		return account;
	}
	
	

}
