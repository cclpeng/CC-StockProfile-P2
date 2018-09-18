package com.revature.dao;

import java.sql.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.StockTransaction;
import com.revature.util.HibernateUtil;

public class StockTransactionDaoImpl implements StockTransactionDao{

	@Override
	public List<StockTransaction> getTransactions() {
		Session s = HibernateUtil.getSession();
		String hql = "from StockTransaction";
		Query q = s.createQuery(hql);
		List<StockTransaction> transactions = q.list();
		s.close();
		return transactions;
	}

	@Override
	public List<StockTransaction> getTransactionsOfUser(int id) {
		Session s = HibernateUtil.getSession();
		String hql = "from StockTransaction where user = :idVar";
		Query q = s.createQuery(hql);
		q.setInteger("idVar",id);
		List<StockTransaction> transactions = q.list();
		s.close();
		return transactions;
	}

	@Override
	public List<StockTransaction> getTransactionsByDate(Date transDate) {
		Session s = HibernateUtil.getSession();
		String hql = "from StockTransaction where date = :dateVar";
		Query q = s.createQuery(hql);
		q.setDate("dateVar",transDate);
		List<StockTransaction> transactions = q.list();
		s.close();
		return transactions;	
	}

	@Override
	public StockTransaction getTransactionById(int id) {
		Session s = HibernateUtil.getSession();
		StockTransaction transaction = (StockTransaction) s.get(StockTransaction.class, id);
		s.close();
		return transaction;
	}

	@Override
	public void updateTransaction(StockTransaction st) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(st);
		tx.commit();
		s.close();
	}

	@Override
	public int createTransaction(StockTransaction st) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int stockPK = (Integer) s.save(st);
		tx.commit();
		s.clear();
		return stockPK;
	}

	@Override
	public void deleteTransaction(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		StockTransaction st = (StockTransaction) s.get(StockTransaction.class, id);
		if(st != null)
		{
			s.delete(st);
		}
		tx.commit();
		s.close();
	}

}
