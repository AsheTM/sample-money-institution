package org.money.institution.views;

import org.money.institution.entities.Account;

public class AccountResponseView implements IResponseView {
	
	private Account account;

	public AccountResponseView() {
	}

	public AccountResponseView(Account account) {
		super();
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	public static AccountResponseView from(Account account) {
		return new AccountResponseView(account);
	}
}
