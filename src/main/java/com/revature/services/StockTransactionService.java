package com.revature.services;

import java.util.List;

import com.revature.models.StockTransaction;

public interface StockTransactionService {

		public List<StockTransaction> getStockTransactions();
		public StockTransaction getStockTransactionById(Long id);
		public StockTransaction createStockTransaction(StockTransaction stockTransaction);
		public StockTransaction updateStockTransaction(StockTransaction stockTransaction);
		public StockTransaction deleteStockTransaction(StockTransaction stockTransaction);
}
