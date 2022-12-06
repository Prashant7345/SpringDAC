package com.met.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.met.dao.EmployeeDAO;
import com.met.model.Employee;

//@Component
@Service
public class EmployeeService {

	//EmployeeDAO employeeDAO = new EmployeeDAO();
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	public void saveEmployee(Employee employee){
		
		
		System.out.println("EMployeeDAO class :: " + employeeDAO.getClass());
		
		System.out.println("Perform user data validation");
		
		String emailId = employee.getEmailId();
		
		if(!emailId.contains("@") && !emailId.contains(".")){
			
			throw new RuntimeException("Email Id is invalid...");
			
		}
		
		employeeDAO.saveEmployee(employee);
		
	}
	
	public List<Employee> getAllEmployees(){
		
		return employeeDAO.getAllEmployees();
		
	}
	
}
