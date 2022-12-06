package com.met.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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
		
		Employee employee2 = context.getBean("employee2", Employee.class);
		System.out.println("Employee with bean id employee2  " + employee2);
		
		Employee employee2SingleTon = context.getBean("employee2", Employee.class);
		System.out.println("Employee with bean id employee2  " + employee2SingleTon);
		
		
		System.out.println("**************************** Singleton Bean scope****************************");
		
		Employee employee3 = context.getBean("employee3", Employee.class);
		System.out.println(employee3);
		
		Employee employee3Prototype = context.getBean("employee3", Employee.class);
		System.out.println("Employee with bean id employee3  " +employee3Prototype);
		
		
	}
	
}
