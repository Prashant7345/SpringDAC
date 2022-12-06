package com.hibernate.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.met.model.Account;

public class CRUDTest {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	
	/*{
		
		Configuration configuration = new Configuration();
		Configuration cfg = configuration.configure();
		sessionFactory = cfg.buildSessionFactory();
	}*/
	
	
	private void saveUsingHibernate(Account acc){
		
		try(Session session = sessionFactory.openSession()){			//session is connection to db
			
			
			// account object state :: Transient
			
			Transaction  tx = session.beginTransaction();				//tx is used to kick off tx management
			
			Serializable idValue = session.save(acc);
			
			// account object state :: Persistence
			
			System.out.println("Post Save with id ::    " + idValue) ;
			
			tx.commit();
			System.out.println("Account with id: " + acc.getId() + " saved to db");
			
		}
		
		//// account object state :: Dettached
		
	}

	public void getAccount(int id){
		
		try(Session session = sessionFactory.openSession()){
			
			Account account = session.get(Account.class, id);
										// 2nd arguement is primary column value
			
									//session.get(className.class, Serializable)
			
			//acc object is persistent

			System.out.println("Object is in persistent context: " + session.contains(account) );
			
			/*session.evict(account);		//hibernate API
			System.out.println("Object is in persistent context: " + session.contains(account) );*/
			
			
			Account account1 = session.get(Account.class, id);
			
			
			System.out.println("Account Holder Name: " + account.getName());
			System.out.println("Interest Amount: " + account.calculateInterest(3));
			
			System.out.println("Account Holder Name: " + account1.getName());
			System.out.println("Interest Amount: " + account1.calculateInterest(3));
			
			
			if(account == account1){
				System.out.println("Accounts are identical");
			}else{
				System.out.println("Accounts are not identical");
			}
			
			
			
			
		}
		
		//acc object state is dettached.
		
	}
	
	
	public void getAccountNotIdentical(int id){
		
		try(Session session = sessionFactory.openSession()){
			
			Account account = session.get(Account.class, id);
										// 2nd arguement is primary column value
			
									//session.get(className.class, Serializable)
			
			//acc object is persistent

			System.out.println("Object is in persistent context: " + session.contains(account) );
			
			/*session.evict(account);		//hibernate API
			System.out.println("Object is in persistent context: " + session.contains(account) );*/
			
			
			Account account1 = session.get(Account.class, 3);
			
			
			System.out.println("Account Holder Name: " + account.getName());
			System.out.println("Interest Amount: " + account.calculateInterest(3));
			
			System.out.println("Account Holder Name: " + account1.getName());
			System.out.println("Interest Amount: " + account1.calculateInterest(3));
			
			
			if(account == account1){
				System.out.println("Accounts are identical");
			}else{
				System.out.println("Accounts are not identical");
			}
			
		}
		
		//acc object state is dettached.
	}
	
	
	public void updateAccount(int id){			//Persistent state works with dirty checking
		
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			
			Account account = session.get(Account.class, id);
			
			account.setActive(true);
			account.setBalance(800000);
			
			tx = session.beginTransaction();
			//session.update(account);
			
			tx.commit();
		}
			
		
	}
	
	
	public void updateWithDettached(int id){
		
		Account account = null;
		Transaction tx = null;
		try(Session session = sessionFactory.openSession()){
			
			account = session.get(Account.class, id);
			
			
			
			//account object state is persistent
			
		}
		
		//account object state is dettached
		
		//after 20 misn uder makes update to dettach object
		
		
		account.setBalance(820000);
		account.setActive(true);
		
		try(Session session = sessionFactory.openSession()){
		
			
			//some stsmt 
			
			tx = session.beginTransaction();
			
			//Account account1 = session.get(Account.class, id);  //if you uncomment this code update will fail.
			
			session.update(account);
			//account is in persisted state
			
			tx.commit();
			
		}catch (HibernateException e) {
			e.printStackTrace();
			if(tx != null) tx.rollback();
			
			
		}
		
		
		
	}
	
	
	public void updateWithTransient(){
		
		try(Session session = sessionFactory.openSession()){
			
			Account acc = new Account();
			//acc.setId(1);
			acc.setBalance(150145);
			acc.setName("Kiran");
			
			
			Transaction tx = session.beginTransaction();
			
			session.update(acc);
			
			tx.commit();
			
		}
		
		//saveOrUpdate
		
	}
	
	
	public void deleteAccount(int id){
		
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			
			tx = session.beginTransaction();
			
			Account account = session.get(Account.class, id);
			
			session.delete(account);
			
			tx.commit();
			
		}
		
		
		//delete with dettached object
		
		/*Account account  = null;
		
		try(Session session = sessionFactory.openSession()){
			
			account = session.get(Account.class, id);
		}
		
		try(Session session = sessionFactory.openSession()){
			
			tx = session.beginTransaction();
			
			session.delete(account);
			
			tx.commit();
			
			
		}*/
		
	}
	
	
	public void evictAccount(){
		
		try(Session session = sessionFactory.openSession()){
			
			
			Account account2 = session.get(Account.class, 2);
			
			Account account4 = session.get(Account.class, 4);
			
			
			System.out.println("account 2 exists in persistent Context: " + session.contains(account2));
			System.out.println("account 4 exists in persistent Context: " + session.contains(account4));
			
			//session.evict(account4);
			
			session.clear();
			
			System.out.println("account 2 exists in persistent Context: " + session.contains(account2));
			System.out.println("account 4 exists in persistent Context: " + session.contains(account4));
			
			
		}
		
		//here in transient state
		
	}
	
	
	public void loadAccount(){
		
		try(Session session = sessionFactory.openSession()){
			
			
			Account account2 = session.get(Account.class, 2);
			System.out.println("After session get method invoked");
			System.out.println(account2.getClass());
			
			Account account4 = session.load(Account.class, 10);
			System.out.println("After session load method invoked");
			System.out.println(account4.getClass());
			System.out.println("account4 id: "  + account4.getId());
			
			System.out.println("account4 balance: "  + account4.getBalance());
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Account acc = new Account();
		//acc.setId(3);							//assigned identifer
										//generated identifier
		
		acc.setName("Jill");
		acc.setBalance(800000);
		acc.setActive(false);
		
		
		CRUDTest crudTest = new CRUDTest();
		//crudTest.saveUsingHibernate(acc);
		
		//crudTest.getAccount(2);
		
		//crudTest.updateAccount(2);
		
		//crudTest.updateWithDettached(2);
		
		//crudTest.updateWithTransient();
		
		//crudTest.deleteAccount(5);
		
		//crudTest.evictAccount();
		
		
		crudTest.loadAccount();
		
		sessionFactory.close();
		
	}
	
}
