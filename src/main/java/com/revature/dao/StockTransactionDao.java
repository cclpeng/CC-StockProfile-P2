package com.revature.dao;

import java.sql.Date;
import java.util.List;

import com.revature.models.StockTransaction;

public interface StockTransactionDao {
	
	public List<StockTransaction> getTransactions();
	public List<StockTransaction> getTransactionsOfUser(int id);
	public List<StockTransaction> getTransactionsByDate(Date transDate);
	public StockTransaction getTransactionById(int id);
	public void updateTransaction(StockTransaction st);
	public int createTransaction(StockTransaction st);
	public void deleteTransaction(int id);
}
