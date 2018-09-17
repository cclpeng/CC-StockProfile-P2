package com.revature.dao;

import java.sql.Date;
import java.util.List;

import com.revature.models.StockTransaction;

public interface TransactionDao {
	
	public List<StockTransaction> getTransactions();
	public List<StockTransaction> getTransactionsByUser(int id);
	public List<StockTransaction> getTransactionsByDate(Date date);
	public StockTransaction getTransactionById(int id);
	public StockTransaction getTransactionByStockSymbol(String stockSymbol);
	public int createTransaction(StockTransaction transaction);
	public int updateTransaction(int id);
	public int deleteTransaction(int id);
}
