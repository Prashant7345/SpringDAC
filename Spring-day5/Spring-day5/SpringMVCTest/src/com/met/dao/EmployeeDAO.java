package com.met.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.met.model.Employee;

//@Component
@Repository
public class EmployeeDAO {

	public void saveEmployee(Employee employee){
		
		System.out.println("Save employee to db..");
		
	}
	
}
