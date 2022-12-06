package com.hibernate.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.met.model.Account;

public class NamedQueryTest {

private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	
	public static void main(String[] args) {
		
		try(Session session = sessionFactory.openSession()){
	
			Query<Account> createNamedQuery = session.createNamedQuery("getAllAccounts", Account.class);
			//createNamedQuery.setMaxResults(2);
			List<Account> list = createNamedQuery.list();
			
			list.forEach(x -> System.out.println(x));
			
			
			//getAccountByName
			
			Query<Account> createNamedQuery2 = session.createNamedQuery("getAccountByName", Account.class);
			createNamedQuery2.setParameter("nameVal", "Tim");
			List<Account> list2 = createNamedQuery2.list();
			
			list2.forEach(x -> System.out.println(x));
		}
	}
	
}
