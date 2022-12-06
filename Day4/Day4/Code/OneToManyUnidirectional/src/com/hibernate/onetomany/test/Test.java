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
		
		
		Employee employee = new Employee();
		employee.setName("Rahul");
		employee.setEmailId("rahu@met.edu");
		
		Address address1 = new Address();
		address1.setCity("Texas");
		address1.setCountry("USA");
		
		Address address2 = new Address();
		address2.setCity("Paris");
		address2.setCountry("France");
		
		
		List<Address> listAddress = new ArrayList<>(2);
		listAddress.add(address1);
		listAddress.add(address2);
		
		
		employee.setListAddress(listAddress);
		
		
		try(Session session = sessionFactory.openSession()){
			
			Transaction tx = session.beginTransaction();
			
			session.save(employee);
			
			tx.commit();
			
		}
		
		System.out.println("Employee and address saved to db");
		
		
		
		
		
		
		
	}
	
}
