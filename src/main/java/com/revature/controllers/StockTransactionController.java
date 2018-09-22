package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.StockTransaction;
import com.revature.services.StockTransactionService;

@RestController
@RequestMapping("/stockTransactions")
public class StockTransactionController {
	
	@Autowired
	StockTransactionService stockService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StockTransaction> findAllStockTransactions(){
		return stockService.getStockTransactions();
	}

}
