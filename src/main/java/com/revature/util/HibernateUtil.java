package com.revature.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	//singleton design pattern
	private static SessionFactory sf; 	//make static. want sf to belong to the class. keep track of only 1 sf
	
	private HibernateUtil() {}
	public static SessionFactory getSessionFactory(String filename)
	{
		if(HibernateUtil.sf == null)
		{
			//make Configuration
			Configuration c = new Configuration().configure(filename);
			ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
			HibernateUtil.sf = c.buildSessionFactory(sr);
			//set sf by using connection's methods
		}
		return sf;
	}
	
	public static Session getSession()
	{
		return getSessionFactory("hibernate.cfg.xml").openSession();
	}
	
}
