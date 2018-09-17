package com.revature.dao;

import java.util.List;

import com.revature.models.StockTransaction;

public interface StockTransactionDao {
	
	public List<StockTransaction> getTransactions();
	public List<StockTransaction> getTransactionsOfUser();
	public List<StockTransaction> getTransactionsByDate();
	public StockTransaction getTransactioById(int id);
	public void updateTransaction(StockTransaction st);
	public int createTransaction(StockTransaction st);
	public int deleteTransaction(int id);
}
