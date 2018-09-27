package com.revature.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.StockTransaction;
import com.revature.services.StockTransactionService;

@RestController
@RequestMapping("/stockTransactions")
@CrossOrigin
public class StockTransactionController {
	
	@Autowired
	StockTransactionService stockService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<StockTransaction> findAllStockTransactions(){
		return stockService.getStockTransactions();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public StockTransaction findStockById(@PathVariable("id") Long id) {
		return stockService.getStockTransactionById(id);
	}
	
	@PostMapping(consumes=MediaType.APPLICATION_JSON_VALUE)
	public StockTransaction addStock(@Valid @RequestBody StockTransaction s) {
		return stockService.createStockTransaction(s);
	}
	
	@PutMapping(consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public StockTransaction updateUser(@RequestBody StockTransaction s) {
		return stockService.updateStockTransaction(s);
	}
	
	@Transactional
	@DeleteMapping(value="/{id}", consumes="application/json")
	public String deleteTransaction(@PathVariable("id") Long id) 
	{
		StockTransaction transaction = stockService.getStockTransactionById(id);
		if(transaction != null) {
			stockService.deleteStockTransaction(transaction);
			return "Deleted the transaction";
		}
		
		return "Didn't delete";
		
	}
	
	

}
