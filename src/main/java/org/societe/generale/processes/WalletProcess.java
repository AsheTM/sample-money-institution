package org.societe.generale.processes;

import org.societe.generale.entities.Account;
import org.societe.generale.entities.Transaction;
import org.springframework.stereotype.Component;

@Component
public interface WalletProcess {
	
	Account withdraw(Account account, Transaction transaction);
	
	Account deposit(Account account, Transaction transaction);

}
