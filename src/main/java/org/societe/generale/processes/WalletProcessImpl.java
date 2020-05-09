package org.societe.generale.processes;

import java.math.BigDecimal;

import org.aspectj.lang.annotation.Before;
import org.societe.generale.entities.Account;
import org.societe.generale.entities.Transaction;
import org.springframework.stereotype.Component;

@Component
public class WalletProcessImpl implements WalletProcess {

	@Before("execution(public * *(..)")
	@Override
	public Account withdraw(Account account, Transaction transaction) {
		BigDecimal amount = transaction.getAmount();
		BigDecimal result = amount.abs().multiply(BigDecimal.valueOf(-1));
		transaction.setAmount(result);
		account.getTransactions().add(transaction);
		
		BigDecimal money = account.getBalance();
		money.add(result);
		account.setBalance(money);
		
		return account;
	}

	@Override
	public Account deposit(Account account, Transaction transaction) {
		BigDecimal amount = transaction.getAmount();
		BigDecimal result = amount.abs().multiply(BigDecimal.valueOf(1));
		transaction.setAmount(result.abs());
		account.getTransactions().add(transaction);
		
		BigDecimal money = account.getBalance();
		money.add(result);
		account.setBalance(money);
		
		return account;
	}

}
