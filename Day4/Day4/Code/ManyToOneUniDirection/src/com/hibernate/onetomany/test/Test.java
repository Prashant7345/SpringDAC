package com.hibernate.onetomany.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.met.model.Address;
import com.met.model.Employee;

public class Test {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		
		
		/*Employee employee = new Employee();
		employee.setName("Jack");
		employee.setEmailId("jack@met.edu");
		
		Address address1 = new Address();
		address1.setCity("Mumbai");
		address1.setCountry("India");
		
		Address address2 = new Address();
		address2.setCity("Pune");
		address2.setCountry("India");
		
		address1.setEmployee(employee);
		address2.setEmployee(employee);
		
		
		
		try(Session session = sessionFactory.openSession()){
			
			Transaction tx = session.beginTransaction();
			
			//session.save(employee);
			
			session.save(address1);
			session.save(address2);
			
			tx.commit();
			
		}
		
		System.out.println("Employee and address saved to db");
		*/
		
		Address address1 = new Address();
		address1.setCity("New Jersey");
		address1.setCountry("USA");
		
		
		try(Session session = sessionFactory.openSession()){
					
					Transaction tx = session.beginTransaction();
					
					Employee employee = session.load(Employee.class, 2);
					
					address1.setEmployee(employee);
					
					
					session.save(address1);
					
					
					tx.commit();
					
		}
		
		
	}
	
}
