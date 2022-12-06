package com.hibernate.test;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.met.model.Account;

public class HibernateTest {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	
	/*{
		
		Configuration configuration = new Configuration();
		Configuration cfg = configuration.configure();
		sessionFactory = cfg.buildSessionFactory();
	}*/
	
	
	private void saveUsingHibernate(Account acc){
		
		try(Session session = sessionFactory.openSession()){			//session is connection to db
			
			Transaction  tx = session.beginTransaction();				//tx is used to kick off tx management
			
			//session.persist(acc);
			
			
			Serializable idValue = session.save(acc);
			
			System.out.println("Post Save with id ::    " + idValue) ;
			
			//System.out.println("Post Persist ::    ");			
			
			//session.flush();
			
			tx.commit();
				//1 -> Fire SQL querey to save/update... to db    --->   session.flush()
				//2 -> commit the tx
			
			
			//tx.commit -> session.flush() + commit 
			
			System.out.println("Account with id: " + acc.getId() + " saved to db");
			
		}
		
	}

	public static void main(String[] args) {
		
		Account acc = new Account();
		acc.setId(2);
		acc.setName("Jack");
		acc.setBalance(500000);
		acc.setActive(false);
		
		
		HibernateTest hibernateTest = new HibernateTest();
		hibernateTest.saveUsingHibernate(acc);
		
		
		sessionFactory.close();
		
	}
	
}
