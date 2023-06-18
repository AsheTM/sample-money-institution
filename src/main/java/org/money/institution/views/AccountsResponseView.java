package org.money.institution.views;

import java.util.List;

import org.money.institution.entities.Account;

public class AccountsResponseView implements IResponseView {
	
	private List<Account> accounts;

	public AccountsResponseView() {
	}

	public AccountsResponseView(List<Account> accounts) {
		super();
		this.accounts = accounts;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	public static List<Account> to(AccountsResponseView accountsResponseView) {
		return accountsResponseView.getAccounts();
	}
	
	public static AccountsResponseView from(List<Account> accounts) {
		return new AccountsResponseView(accounts);
	}

}
