package com.met.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.met.dao.EmployeeDAO;
import com.met.model.Employee;

//@Component
@Service
public class EmployeeService {

	//EmployeeDAO employeeDAO = new EmployeeDAO();
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	
	@Transactional(transactionManager="hibernateTransactionManager", timeout=10, rollbackFor=Exception.class,
			noRollbackFor=NullPointerException.class)														
								//Declarative transaction manager
	public void saveEmployee(Employee employee){
		
		
		System.out.println("EMployeeDAO class :: " + employeeDAO.getClass());
		
		System.out.println("Perform user data validation");
		
		String emailId = employee.getEmailId();
		
		if(!emailId.contains("@") && !emailId.contains(".")){
			
			throw new RuntimeException("Email Id is invalid...");
			
		}
		
		employeeDAO.saveEmployee(employee);
		//employeeDAO.updateEmployeeCount(employee);
		
	}
	
	public List<Employee> getAllEmployees(){
		
		return employeeDAO.getAllEmployees();
		
	}
	
	public Employee getEmployee(int id){
		
		return employeeDAO.getEmployee(id);
		
	}
	
}
