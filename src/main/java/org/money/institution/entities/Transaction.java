package org.money.institution.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
	
	private static int counter = 0;
	
	{ counter++; }
	
	private int id = -1;
	
	private BigDecimal amount = BigDecimal.ZERO;
	
	private LocalDateTime doneAt = LocalDateTime.now();

	public Transaction() {
		this.id = counter;
	}

	public Transaction(BigDecimal amount) {
		this.id = counter;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getDoneAt() {
		return doneAt;
	}

	public static TransactionBuilder builder() {
		return new TransactionBuilder();
	}
	
	public static class TransactionBuilder {
		
		private Transaction transaction = new Transaction();

		public TransactionBuilder() { }
		
		public TransactionBuilder(Transaction transaction) {
			this.transaction = transaction;
		}
		
		public TransactionBuilder amount(BigDecimal amount) {
			this.transaction.setAmount(amount);
			return this;
		}
		
		public Transaction build() {
			return this.transaction;
		}
		
	}
	
	@Override
	public String toString() {
		return "- Id " + this.getId() + ": " + this.getAmount() + " at " + this.getDoneAt();
	}

}
