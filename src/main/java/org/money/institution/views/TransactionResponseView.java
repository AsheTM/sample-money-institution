package org.money.institution.views;

import org.money.institution.entities.Transaction;

public class TransactionResponseView implements IResponseView {
	
	private Transaction transaction;

	public TransactionResponseView() {
	}

	public TransactionResponseView(Transaction transaction) {
		super();
		this.transaction = transaction;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	public static Transaction to(TransactionResponseView transactionResponseView) {
		return transactionResponseView.getTransaction();
	}
	
	public static TransactionResponseView from(Transaction transaction) {
		return new TransactionResponseView(transaction);
	}

}
