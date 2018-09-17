package com.revature.models;

import javax.persistence.*;

public class Transaction {
	
	@Id
	private int id;
	
	@Column(name = "STOCK_SYMBOL")
	private String stockSymbol;

}
