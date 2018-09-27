package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.StockTransaction;
import com.revature.repositories.StockTransactionRepository;

@Service
public class StockTransactionImpl implements StockTransactionService {
	
	@Autowired
	StockTransactionRepository stockTransactionRepo;

	@Override
	public List<StockTransaction> getStockTransactions() {
		return stockTransactionRepo.findAll();
	}

	@Override
	public StockTransaction getStockTransactionById(Long id) {
		return stockTransactionRepo.getOne(id);
	}

	@Override
	public StockTransaction createStockTransaction(StockTransaction stockTransaction) {
		return stockTransactionRepo.save(stockTransaction);
	}

	@Override
	public StockTransaction updateStockTransaction(StockTransaction stockTransaction) {
		return stockTransactionRepo.save(stockTransaction);
	}

	@Override
	public StockTransaction deleteStockTransaction(StockTransaction stockTransaction) {
		stockTransactionRepo.delete(stockTransaction);
		return stockTransaction;
	}

}
