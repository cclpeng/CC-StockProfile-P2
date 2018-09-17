package com.revature.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.StockTransaction;
import com.revature.util.HibernateUtil;

public class TransactionDaoImpl implements TransactionDao{

	public List<StockTransaction> getTransactions() {
		Session s = HibernateUtil.getSession();
		String hql = "from StockTransaction";
		Query q = s.createQuery(hql);
		List<StockTransaction> stockTransaction = q.list();
		return stockTransaction;
	}

	public List<StockTransaction> getTransactionsByUser(int id) {
		Session s = HibernateUtil.getSession();
		String hql = "from StockTransaction where  user = :userVar ";
		Query q = s.createQuery(hql);
		q.setInteger("userVar", id);
		List<StockTransaction> transactions = q.list(); 
		return transactions;
	}

	public List<StockTransaction> getTransactionsByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	public StockTransaction getTransactionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public StockTransaction getTransactionByStockSymbol(String stockSymbol) {
		// TODO Auto-generated method stub
		return null;
	}

	public int createTransaction(StockTransaction transaction) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int tPK = (Integer) s.save(transaction);
		tx.commit();
		s.close();
		return tPK;
	}

	public int updateTransaction(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteTransaction(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
