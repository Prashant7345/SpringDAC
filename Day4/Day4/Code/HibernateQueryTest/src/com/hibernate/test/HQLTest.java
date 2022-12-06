package com.hibernate.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.met.model.Account;

import java.util.List;
import java.util.concurrent.SynchronousQueue;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HQLTest {

	
	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	
	public static void main(String[] args) {
		
		try(Session session = sessionFactory.openSession()){
			
			
			System.out.println("Fetching all records from Account_TBL");
			
			//select * from Account_TBL order by acc_id;
			
			Query<Account> createQuery = session.createQuery("from com.met.model.Account order by id", Account.class);
			List<Account> list = createQuery.list();
			
			for(Account acc : list){
				System.out.println(acc);
			}
			
			System.out.println();
			System.out.println("Fetching only 2 records from Account_TBL");
			
			Query<Account> createQuery1 = session.createQuery("from com.met.model.Account order by id", Account.class);
			createQuery1.setMaxResults(2);
			List<Account> list2 = createQuery1.list();
			
			list2.forEach(x -> System.out.println(x));
			
			
			System.out.println();
			System.out.println("Filter records from Account_TBL");
			
			
			Query<Account> createQuery2 = session.createQuery("from com.met.model.Account where name=:nameVal", Account.class);
			createQuery2.setParameter("nameVal", "Tim");
			//List<Account> list3 = createQuery2.list();
			//list3.forEach(x -> System.out.println(x));
			
			
			Account account = createQuery2.getSingleResult();
			System.out.println(account);
			
			System.out.println();
			System.out.println("Aggregation records from Account_TBL");
			
			
			Query<Double> createQuery3 = session.createQuery("select sum(balance) from com.met.model.Account", Double.class);
			double sumBalance = createQuery3.uniqueResult();
			System.out.println("SUM Balance: " + sumBalance);
			
			
			
			
			
		}
		
		
	}
	
}
