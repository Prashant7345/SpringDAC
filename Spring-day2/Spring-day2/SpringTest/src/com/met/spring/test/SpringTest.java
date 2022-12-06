package com.met.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.met.model.Address;
import com.met.model.Employee;

public class SpringTest {

	public static void main(String[] args) {
		
		//new FileSystemXmlApplicationContext("F:\\CDAC-BANDRA\\June-2022\\Spring\\abc.xml");
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("test.xml");
		
		System.out.println("****************************Post Initialization of S.C ****************************");
		
		/*Employee bean = context.getBean(Employee.class);			//Only type name
		System.out.println(bean);*/
		
		Employee emp = (Employee) context.getBean("employee1");		//only bean id
		System.out.println(emp); 
		
		Employee employee1 = context.getBean("employee1", Employee.class);
		System.out.println(employee1);
		
		System.out.println("**************************** Singleton Bean scope****************************");
		
		Employee employee2 = context.getBean("employee2", Employee.class);
		System.out.println("Employee with bean id employee2  " + employee2);
		
		Employee employee2SingleTon = context.getBean("employee2", Employee.class);
		System.out.println("Employee with bean id employee2  " + employee2SingleTon);
		
		
		System.out.println("**************************** Prototype Bean scope****************************");
		
		Employee employee3 = context.getBean("employee3", Employee.class);
		System.out.println(employee3);
		
		Employee employee3Prototype = context.getBean("employee3", Employee.class);
		System.out.println("Employee with bean id employee3  " +employee3Prototype);
		
		System.out.println("**************************** Parameterized construtor****************************");
		
		Employee employee4 = context.getBean("employee4", Employee.class);
		System.out.println("Employee with bean id employee4: " + employee4);
		
		Employee employee5 = context.getBean("employee5", Employee.class);
		System.out.println("Employee with bean id employee5: " + employee5);
		
		System.out.println("**************************** Property Setter ****************************");
		
		
		Employee employee6 = context.getBean("employee6", Employee.class);
		System.out.println("Employee with bean id employee6: " + employee6);
		
		System.out.println("**************************** Combination of Constructor and Property Setter ****************************");
		Employee employee7 = context.getBean("employee7", Employee.class);
		System.out.println("Employee with bean id employee7: " + employee7);		
		
		System.out.println("**************************** Combination of Constructor and Property Setter ****************************");
		Employee employee8 = context.getBean("employee8", Employee.class);
		System.out.println("Employee with bean id employee8: " + employee8);	
		
		Employee employee8Lazy = context.getBean("employee8", Employee.class);
		System.out.println("Employee with bean id employee8: " + employee8Lazy);
		
		
		System.out.println("**************************** Address object ****************************");
		
		Address address = context.getBean("address1", Address.class);
		System.out.println("address1 bean details" + address);
		
		Employee employee9 = context.getBean("employee9", Employee.class);
		System.out.println("Employee with bean id employee9: " + employee9);	
	}
	
}



