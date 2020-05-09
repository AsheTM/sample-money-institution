package org.societe.generale.views;

import java.time.LocalDate;

import org.societe.generale.entities.Transaction;

public class TransactionResponseView implements ResponseView {
	
	private Transaction transaction;
	
	private LocalDate now = LocalDate.now();

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
