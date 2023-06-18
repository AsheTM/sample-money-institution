package org.money.institution.views;

import java.util.List;

import org.money.institution.entities.Transaction;

public class TransactionsResponseView implements IResponseView {
	
	private List<Transaction> transactions;

	public TransactionsResponseView() {
	}

	public TransactionsResponseView(List<Transaction> transactions) {
		super();
		this.transactions = transactions;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	public static List<Transaction> to(TransactionsResponseView transactionsResponseView) {
		return transactionsResponseView.getTransactions();
	}
	
	public static TransactionsResponseView from(List<Transaction> transaction) {
		return new TransactionsResponseView(transaction);
	}

}
