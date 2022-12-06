package com.hibernate.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.met.model.Account;
import com.met.model.Employee;

public class CriteriaTest {

private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		try(Session session = sessionFactory.openSession()){
			
			/*System.out.println("Fetching all records from Account_TBL");
			
			Criteria createCriteria = session.createCriteria(Account.class);
			List list = createCriteria.list();
			
			list.forEach(x -> System.out.println(x));
			
			System.out.println();
			System.out.println("Fetching only 2 records from Account_TBL");
			
			Criteria createCriteria2 = session.createCriteria(Account.class);
			createCriteria2.setMaxResults(2);
			createCriteria2.addOrder(Order.desc("id"));
			List list2 = createCriteria2.list();
			list2.forEach(x -> System.out.println(x));
			
			System.out.println();
			System.out.println("Filter records from Account_TBL");
			
			Criteria createCriteria3 = session.createCriteria(Account.class);
			createCriteria3.add(Restrictions.eq("name", "Tim"));
			System.out.println(createCriteria3.uniqueResult());
			
			
			System.out.println();
			System.out.println("Aggregation records from Account_TBL");
			
			Criteria createCriteria4 = session.createCriteria(Account.class);
			createCriteria4.setProjection(Projections.sum("balance"));
			System.out.println(createCriteria4.uniqueResult());*/
			
			
			/*Criteria createCriteria5 = session.createCriteria(Employee.class);
			List<Employee> list = createCriteria5.list();
			
			System.out.println();
			System.out.println();
			System.out.println("Fetching addreeess details for each employee");
			
			for(Employee emp : list){
				
				System.out.println("Iterating for emp id: " + emp.getId());
				
				System.out.println(emp.getListAddress()); 						//lazy loaded
				
				System.out.println();
				
			}
			*/
			
			Criteria createCriteria5 = session.createCriteria(Employee.class);
			createCriteria5.setFetchMode("listAddress", FetchMode.EAGER);
			List<Employee> list = createCriteria5.list();
			
			System.out.println();
			System.out.println();
			System.out.println("Fetching addreeess details for each employee");
			
			for(Employee emp : list){
				
				System.out.println("Iterating for emp id: " + emp.getId());
				
				System.out.println(emp.getListAddress()); 						//lazy loaded
				
				System.out.println();
				
			}
			
		}
		
	}	
	
}
