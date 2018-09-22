package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.StockTransaction;

public interface StockTransactionRepository  extends JpaRepository<StockTransaction, Long>{
	
}
