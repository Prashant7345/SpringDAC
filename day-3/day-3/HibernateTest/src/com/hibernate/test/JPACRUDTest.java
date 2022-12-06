package com.hibernate.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.met.model.Account;

public class JPACRUDTest {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	private static void saveUsingJPA(Account acc){
		
		try(Session session = sessionFactory.openSession()){			//session is connection to db
			
			Transaction  tx = session.beginTransaction();				//tx is used to kick off tx management
			
			//Serializable idValue = session.save(acc);
			
			session.persist(acc);
			
			tx.commit();
			System.out.println("Account with id: " + acc.getId() + " saved to db");
			
		}
		
		//// account object state :: Dettached
		
	}
	
	
	private static void mergeAccountForPersistent(int id){			//Persistent state works with dirty checking
		
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			
			Account account = session.get(Account.class, id);
			
			account.setActive(true);
			account.setBalance(500000);
			
			tx = session.beginTransaction();
			session.merge(account);
			
			tx.commit();
		}
	}
	
	public static void mergeWithDettached(int id){
		
		Account account = null;
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			
			account = session.get(Account.class, id);				// id = 8
			
			
			
			//account object state is persistent
			
		}
		
		//account object state is dettached
		
		//after 20 misn user makes update to dettach object
		
		
		account.setBalance(850000);
		account.setActive(false);
		
		try(Session session = sessionFactory.openSession()){
		
			
			//some stsmt 
			
			tx = session.beginTransaction();
			
			Account account1 = session.get(Account.class, id);
			
			System.out.println("before merging");
			
			session.merge(account);
			//account is in persisted state
			
			tx.commit();
			
		}catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
			
			
		}
		
		
		
	}
	
	
	private static void mergeWithTransient(){
		
		try(Session session = sessionFactory.openSession()){
			
			Account acc = new Account();
			
			acc.setName("Jackie");
			acc.setBalance(80000);
			acc.setActive(true);
			
			Transaction tx = session.beginTransaction();
			
			session.merge(acc);		// or use saveOrUpdate
			
			tx.commit();
			
			
		}
		
	}
	
	
	public static  void removeAccount(int id){
		
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			
			tx = session.beginTransaction();
			
			Account account = session.get(Account.class, id);
			
			session.remove(account);
			
			tx.commit();
			
		}
	}
	
	public static void main(String[] args) {
		
		Account acc = new Account();
		acc.setId(123);							//assigned identifer
										//generated identifier
		
		acc.setName("Jackie");
		acc.setBalance(80000);
		acc.setActive(true);
		
		//saveUsingJPA(acc);
		
		
		//mergeAccountForPersistent(8);
		
		//mergeWithDettached(8);
		
		//mergeWithTransient();
		
		removeAccount(12);
		
		sessionFactory.close();
		
	}
	
}
