package com.jbk.springboot;

import org.springframework.stereotype.Component;

@Component
public class Transaction {
	
	private String transId;
	private String transactionDoneBy;
	private String transSource;
	
	public Transaction() {
		super();
	}
	
	public Transaction(String transId, String transactionDoneBy, String transSource) {
		super();
		this.transId = transId;
		this.transactionDoneBy = transactionDoneBy;
		this.transSource = transSource;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public String getTransactionDoneBy() {
		return transactionDoneBy;
	}

	public void setTransactionDoneBy(String transactionDoneBy) {
		this.transactionDoneBy = transactionDoneBy;
	}

	public String getTransSource() {
		return transSource;
	}

	public void setTransSource(String transSource) {
		this.transSource = transSource;
	}
		
	

}
