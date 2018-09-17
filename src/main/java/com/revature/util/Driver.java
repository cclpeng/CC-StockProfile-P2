package com.revature.util;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.revature.dao.StockTransactionDao;
import com.revature.dao.StockTransactionDaoImpl;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImpl;
import com.revature.models.StockTransaction;
import com.revature.models.User;

public class Driver {

	public static void main(String[] args) {
		//testing session
//		Session s = HibernateUtil.getSession();
//		s.close();
		//testing daos
		
		User u1 = new User("cindy", "password", "cindy peng");
		User u2 = new User("mindy", "password", "mindy cheng");
		User u3 = new User("chris", "password", "chris perry");
		User u4 = new User("chris", "password", "chris perry");
		
		UserDao ud = new UserDaoImpl();
//insertion testing 
		ud.createUser(u1);
		ud.createUser(u2);
		ud.createUser(u3);
		ud.createUser(u4);
		
//get by id testing 
//		User uUpdate = ud.getUserById(1);
//		System.out.println(uUpdate);
		
//update testing
//		uUpdate.setName("peng cindy is UPDATED!!!!!");
//		ud.updateUser(uUpdate);

//list users testing 
//		System.out.println(ud.getUsers());
		
//delete user by id testing 
//		ud.deleteUserById(4);
//
		StockTransaction stock1 = new StockTransaction(u1, "Symbol_1", "Apple", 100, 1000.00f, 1001.00f, 8999.00f,
				1005.00f, BigDecimal.valueOf(1006.00), Date.valueOf("2018-09-17"));
		StockTransaction stock2 = new StockTransaction(u2, "Symbol_2", "Amazon", 80, 1217.76f, 1304.11f, 1997.87f,
				1500.00f, BigDecimal.valueOf(1200.00), Date.valueOf("2017-04-24"));
		StockTransaction stock3 = new StockTransaction(u3, "Symbol_3", "Hershey", 1500, 1965.76f, 2004.11f, 1963.99f,
				150.00f, BigDecimal.valueOf(14.00), Date.valueOf("2010-12-31"));
		StockTransaction stock4 = new StockTransaction(u3, "Symbol_3", "Hershey", 500, 1965.76f, 2004.11f, 1963.99f,
				150.00f, BigDecimal.valueOf(14.00), Date.valueOf("2010-12-31"));
		StockTransaction stock5 = new StockTransaction(u3, "Symbol_3", "Hershey", 600, 1965.76f, 2004.11f, 1963.99f,
				150.00f, BigDecimal.valueOf(14.00), Date.valueOf("2010-12-31"));
		
		StockTransactionDao sd = new StockTransactionDaoImpl();
		
		//Create Test
		sd.createTransaction(stock1);
		sd.createTransaction(stock2);
		sd.createTransaction(stock3);
		sd.createTransaction(stock4);
		sd.createTransaction(stock5);
		
		//Update Test
		stock1.setCurrentPrice(2000);
		sd.updateTransaction(stock1);
		
		//Get All Transactions Test
		/*List<StockTransaction> stockTrans = sd.getTransactions();
		for(StockTransaction s : stockTrans) {
			System.out.println("\n"+ s);
		}*/
		
		//Get All Transactions of a particular date
		/*List<StockTransaction> stockTransByDate = sd.getTransactionsByDate(Date.valueOf("2010-12-31"));
		for(StockTransaction s : stockTransByDate) {
			System.out.println("\n"+ s);
		}*/
		
		//Get Transactions of a User Test
		/*List<StockTransaction> stockTransOfUser = sd.getTransactionsOfUser(u3.getUserId());
		for(StockTransaction s : stockTransOfUser) {
			System.out.println("\n" + s);
		}*/
		
		//Delete Test
		//sd.deleteTransaction(stock2.getId());
		
		//Get Transaction by it's Id
		System.out.println(sd.getTransactionById(1));
	}

}
