package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.models.User;
import com.revature.util.HibernateUtil;

public class UserDaoImpl implements UserDao {

	public List<User> getUsers() {
		String hql = "from User";
		Session s = HibernateUtil.getSession();
		List<User> list =  s.createQuery(hql).list();
		s.close();
		return list;
	}

	public User getUserById(int id) {
		Session s = HibernateUtil.getSession();
		User u = (User) s.get(User.class, id);
		s.close();
		return u;
	}

	public int createUser(User user) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		int indexOfCreated = (Integer) s.save(user);
		tx.commit();
		s.close();
		return indexOfCreated;
	}

	public void updateUser(User user) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.update(user);
		tx.commit();
		s.close();
	}

	public void deleteUserById(int id) {
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		User user = (User) s.get(User.class, id); 
		if(user != null)
			s.delete(user);
		tx.commit();
		s.close();
	}
	
}
